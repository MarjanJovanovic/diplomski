import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Subject } from 'rxjs';
import { StudentDto } from 'src/app/core/models/student.model';
import { CityService } from 'src/app/core/service/city.service';
import { TitleService } from 'src/app/core/service/title.service';
import { MyErrorStateMatcher } from '../../professor/professor-add/professor-add.component';

interface SubjectModalData {
  student: StudentDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Student';
const CREATE_TITLE = 'Add Student';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentAddComponent implements OnInit {

  public semester = new FormControl('', [Validators.required]);
  public title: string;

  public studentAddForm: FormGroup;
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

  cityList = [];
  titleList = [];

  constructor(
    private readonly formBuilder: FormBuilder,
    private readonly dialogRef: MatDialogRef<StudentAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SubjectModalData,
    private readonly cityService: CityService,
    private readonly titleService: TitleService,
  ) {}

  ngOnInit(): void {
    console.log(this.data);

    this.title = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.studentAddForm = this.formBuilder.group({
      id: this.data.student.id,
      firstName: [
        this.data.student.firstName,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      lastName: [
        this.data.student.lastName,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      email: this.data.student.email,
      address: this.data.student.address,
      city: this.data.student.city,
      indexNumber: this.data.student.indexNumber,
      indexYear: this.data.student.indexYear,
      currentYearOfStudy: this.data.student.currentYearOfStudy,
      // exams: this.data.student.exams,
    });
    console.log(this.firstName);
  }

  ngAfterViewInit() {
    this.fetchCities();
    this.fetchTitles();
  }

  public fetchCities(): void {
    this.cityService
      .getAll()
      .subscribe(data => {
        this.cityList = data;
      })
  }

  public fetchTitles(): void {
    this.titleService
      .getAll()
      .subscribe(data => {
        this.titleList = data;
      })
  }

  get firstName() {
    return this.studentAddForm.get('firstName');
  }

  get lastName() {
    return this.studentAddForm.get('lastName');
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public saveStudent() {
    this.dialogRef.close({
      student: this.studentAddForm.value,
    });
  }
}
