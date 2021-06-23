import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Subject } from 'rxjs';
import { ExamPeriodDto } from 'src/app/core/models/exam-period.model';

interface ExamPeriodModalData {
  examPeriod: ExamPeriodDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Exam Period';
const CREATE_TITLE = 'Add Exam Period';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: FormControl | null,
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
  selector: 'app-exam-period-add',
  templateUrl: './exam-period-add.component.html',
  styleUrls: ['./exam-period-add.component.css']
})
export class ExamPeriodAddComponent implements OnInit {
  public semester = new FormControl('', [Validators.required]);
  public title: string;

  public examPeriodAddForm: FormGroup;
  public destroy$: Subject<boolean> = new Subject();

  public selectFormControl = new FormControl('valid', [
    Validators.required,
    // Validators.pattern('valid'),
  ]);

  public nativeSelectFormControl = new FormControl('valid', [
    Validators.required,
    // Validators.pattern('valid'),
  ]);

  public emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly dialogRef: MatDialogRef<ExamPeriodAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ExamPeriodModalData,
  ) {}

  ngOnInit(): void {
    console.log(this.data);
 
    this.title = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.examPeriodAddForm = this.formBuilder.group({
      id: this.data.examPeriod.id,
      name: [
        this.data.examPeriod.name,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      startDate: [this.data.examPeriod.startDate, [Validators.required]],
      endDate: [this.data.examPeriod.endDate, [Validators.required]],
      isActive: [this.data.examPeriod.isActive, [Validators.required]],
    });

    console.log(this.name);
  }

  get name() {
    return this.examPeriodAddForm.get('name');
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public saveExamPeriod() {
    this.dialogRef.close({
      subject: this.examPeriodAddForm.value,
    });
  }
  public closePopup() {
    this.dialogRef.close({
    }); 
  }
}
