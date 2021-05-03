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
import { ProfessorDto } from 'src/app/core/models/professor.model';

interface SubjectModalData {
  professor: ProfessorDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Professor';
const CREATE_TITLE = 'Add Professor';

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
  selector: 'app-professor-add',
  templateUrl: './professor-add.component.html',
  styleUrls: ['./professor-add.component.css'],
})
export class ProfessorAddComponent implements OnInit {
  public semester = new FormControl('', [Validators.required]);
  public title: string;

  public professorAddForm: FormGroup;
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
    private readonly dialogRef: MatDialogRef<ProfessorAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SubjectModalData
  ) {}

  ngOnInit(): void {
    console.log(this.data);

    this.title = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.professorAddForm = this.formBuilder.group({
      id: this.data.professor.id,
      name: [
        this.data.professor.firstName,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      lastName: this.data.professor.lastName,
      email: this.data.professor.email,
      address: this.data.professor.address,
      city: this.data.professor.city,
      phone: this.data.professor.phone,
      reelectionDate: this.data.professor.reelectionDate,
      title: this.data.professor.title,
      subjects: this.data.professor.subjects,
    });

    console.log(this.name);
  }

  get name() {
    return this.professorAddForm.get('firstName');
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public saveProfessor() {
    this.dialogRef.close({
      professor: this.professorAddForm.value,
    });
  }
}
