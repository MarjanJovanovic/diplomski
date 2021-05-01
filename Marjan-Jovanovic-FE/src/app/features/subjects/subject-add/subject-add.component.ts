import { Component, OnInit, Inject } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormGroupDirective,
  NgForm,
  Validators,
} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { SubjectService } from 'src/app/core';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import {
  MatDialogModule,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { SubjectDto } from 'src/app/core/models/subject.model';

interface SubjectModalData {
  subject: SubjectDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Subject';
const CREATE_TITLE = 'Add Subject';

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
  selector: 'app-subject-add',
  templateUrl: './subject-add.component.html',
  styleUrls: ['./subject-add.component.css'],
})
export class SubjectAddComponent implements OnInit {
  public semester = new FormControl('', [Validators.required]);
  public title: string;

  public subjectAddForm: FormGroup;
  public destroy$: Subject<boolean> = new Subject();

  public selectFormControl = new FormControl('valid', [
    Validators.required,
    Validators.pattern('valid'),
  ]);

  public nativeSelectFormControl = new FormControl('valid', [
    Validators.required,
    Validators.pattern('valid'),
  ]);

  public emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly dialogRef: MatDialogRef<SubjectAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SubjectModalData
  ) {}

  ngOnInit(): void {
    console.log(this.data);

    this.title = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.subjectAddForm = this.formBuilder.group({
      id: this.data.subject.id,
      name: [
        this.data.subject.name,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      description: this.data.subject.description,
      noOfEsp: this.data.subject.noOfEsp,
      yearOfStudy: this.data.subject.yearOfStudy,
      semester: this.data.subject.semester,
    });

    console.log(this.name);
  }

  get name() {
    return this.subjectAddForm.get('name');
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public saveSubject() {
    this.dialogRef.close({
      subject: this.subjectAddForm.value,
    });
  }
}
