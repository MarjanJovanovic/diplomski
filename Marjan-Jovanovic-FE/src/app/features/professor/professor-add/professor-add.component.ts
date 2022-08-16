import { Component, OnInit, Inject } from '@angular/core';
import {
  UntypedFormBuilder,
  UntypedFormControl,
  UntypedFormGroup,
  FormGroupDirective,
  NgForm,
  Validators,
} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { takeUntil, tap } from 'rxjs/operators';
import { Subject } from 'rxjs';
import {
  MatDialogModule,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { ProfessorDto } from 'src/app/core/models/professor.model';
import { CityService } from 'src/app/core/service/city.service';
import { TitleService } from 'src/app/core/service/title.service';

interface SubjectModalData {
  professor: ProfessorDto;
  isEditMode: Boolean;
}

const EDIT_TITLE = 'Edit Professor';
const CREATE_TITLE = 'Add Professor';

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
  selector: 'app-professor-add',
  templateUrl: './professor-add.component.html',
  styleUrls: ['./professor-add.component.css'],
})
export class ProfessorAddComponent implements OnInit {
  public title = new UntypedFormControl('', [Validators.required]);
  public city = new UntypedFormControl('', [Validators.required]);
  public componentTitle: string;

  public professorAddForm: UntypedFormGroup;
  public destroy$: Subject<boolean> = new Subject();

  public selectFormControl = new UntypedFormControl('valid', [
    Validators.required,
    Validators.pattern('valid'),
  ]);

  public nativeSelectFormControl = new UntypedFormControl('valid', [
    Validators.required,
    Validators.pattern('valid'),
  ]);

  // public emailFormControl = new FormControl('', [
  //   Validators.required,
  //   Validators.email,
  // ]);

  matcher = new MyErrorStateMatcher();

  cityList = [];
  titleList = [];

  constructor(
    private readonly formBuilder: UntypedFormBuilder,
    private readonly dialogRef: MatDialogRef<ProfessorAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SubjectModalData,
    private readonly cityService: CityService,
    private readonly titleService: TitleService
  ) { }

  ngOnInit(): void {
    console.log(this.data);

    this.componentTitle = this.data.isEditMode ? EDIT_TITLE : CREATE_TITLE;
    this.professorAddForm = this.formBuilder.group({
      id: this.data.professor.id,
      firstName: [
        this.data.professor.firstName,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      lastName: [
        this.data.professor.lastName,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(30),
        ],
      ],
      email: [
        this.data.professor.email,
        [Validators.email, Validators.maxLength(30)],
      ],
      address: [this.data.professor.address, [Validators.maxLength(30)]],
      city: this.data.professor.city,
      phone: [
        this.data.professor.phone,
        [
          Validators.minLength(9),
          Validators.maxLength(15),
          Validators.required,
        ],
      ],
      reelectionDate: [this.data.professor.reelectionDate, [Validators.required]],
      title: [this.data.professor.title,[Validators.required]],
      subjects: this.data.professor.subjects,
    });
  }

  ngAfterViewInit() {
    this.fetchCities();
    this.fetchTitles();
  }

  public fetchCities(): void {
    this.cityService.getAll().subscribe((data) => {
      this.cityList = data;
    });
  }

  public fetchTitles(): void {
    this.titleService.getAll().subscribe((data) => {
      this.titleList = data;
    });
  }

  get firstName() {
    return this.professorAddForm.get('firstName');
  }

  get lastName() {
    return this.professorAddForm.get('lastName');
  }

  get email(){
    return this.professorAddForm.get('email');
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
