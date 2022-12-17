import { Component, Inject, OnInit } from '@angular/core';
import {
  UntypedFormBuilder,
  UntypedFormControl,
  UntypedFormGroup,
  FormGroupDirective,
  NgForm,
  Validators,
} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Subject } from 'rxjs';
import { SubjectService } from 'src/app/core';
import { ExamDto } from 'src/app/core/models/exam.model';
import { ExamPeriodService } from 'src/app/core/service/exam-period.service';
import { ProfessorService } from 'src/app/core/service/professor.service';

interface ExamModalData {
  exam: ExamDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Exam';
const CREATE_TITLE = 'Add Exam';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: UntypedFormControl | null,
    form: FormGroupDirective | NgForm | null
  ): boolean {
    const isSubmitted = form && form.submitted;
    return !!(
      control &&
      control.invalid &&
      (control.dirty || control.touched || isSubmitted)
    );
  }
}

@Component({
  selector: 'app-exam-add',
  templateUrl: './exam-add.component.html',
  styleUrls: ['./exam-add.component.css'],
})
export class ExamAddComponent implements OnInit {
  public examPeriod = new UntypedFormControl('', [Validators.required]);
  public subject = new UntypedFormControl('', [Validators.required]);
  public professor = new UntypedFormControl('', [Validators.required]);

  public title: string;

  public examAddForm: UntypedFormGroup;
  public destroy$: Subject<boolean> = new Subject();

  public selectFormControl = new UntypedFormControl('valid', [
    Validators.required,
    // Validators.pattern('valid'),
  ]);

  public nativeSelectFormControl = new UntypedFormControl('valid', [
    Validators.required,
    // Validators.pattern('valid'),
  ]);

  public emailFormControl = new UntypedFormControl('', [
    Validators.required,
    Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();

  examPeriodList = [];
  subjectList = [];
  professorList = [];

  constructor(
    private readonly formBuilder: UntypedFormBuilder,
    private readonly dialogRef: MatDialogRef<ExamAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ExamModalData,
    private readonly examPeriodService: ExamPeriodService,
    private readonly subjectService: SubjectService,
    private readonly professorService: ProfessorService
  ) {}

  ngOnInit(): void {
    console.log(this.data);

    this.title = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.examAddForm = this.formBuilder.group({
      id: this.data.exam.id,
      examPeriod: [this.data.exam.examPeriod, [Validators.required]],
      subject: [this.data.exam.subject, [Validators.required]],
      professor: [this.data.exam.professor, [Validators.required]],
      date: [this.data.exam.date, [Validators.required]],
    });
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  ngAfterViewInit() {
    this.fetchExamPeriods();
    this.fetchSubjects();
    this.fetchProfessors();
  }

  public fetchExamPeriods(): void {
    this.examPeriodService.getAll().subscribe((data) => {
      this.examPeriodList = data;
    });
  }

  public fetchSubjects(): void {
    this.subjectService.getAll().subscribe((data) => {
      this.subjectList = data;
    });
  }

  public fetchProfessors(): void {
    this.professorService.getAll().subscribe((data) => {
      this.professorList = data;
    });
  }

  public saveExam() {
    console.log(this.examAddForm.value);
    this.dialogRef.close({
      subject: this.examAddForm.value,
    });
  }

  public closePopup() {
    this.dialogRef.close({});
  }
}
