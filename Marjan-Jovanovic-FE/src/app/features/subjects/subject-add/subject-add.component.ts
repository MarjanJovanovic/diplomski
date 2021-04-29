import { Component, OnInit, Inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { SubjectService } from 'src/app/core';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import {MatDialogModule, MAT_DIALOG_DATA} from '@angular/material/dialog';



export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-subject-add',
  templateUrl: './subject-add.component.html',
  styleUrls: ['./subject-add.component.css']
})
export class SubjectAddComponent implements OnInit {

  destroy$: Subject<boolean> = new Subject();


  public subjectAddForm: FormGroup;

  public name = new FormControl( [
    Validators.required,
  ]);

  public semester = new FormControl('', [
    Validators.required,
  ]);

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

  constructor(private formBuilder: FormBuilder, private subjectService: SubjectService, @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.subjectAddForm = this.formBuilder.group({
      id: '0',
      name: '',
      description: '',
      noOfEsp: '',
      yearOfStudy: '',
      semester: ''

    })
    console.log(this.data);

    this.subjectAddForm.valueChanges.subscribe(console.log);
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public saveSubject(){
    console.log("saveSubject()");

    try{
      return this.subjectService.save(this.subjectAddForm.value);
    }catch(error){
      console.error(error);
    }
  }

  onSubmit() {
    this.saveSubject()
    .pipe(
      takeUntil(this.destroy$)
    )
    .subscribe(
      city => {
        // this.toastService.show('City saved!', {header:'Saving city', classname: 'bg-success text-light'});
        // this.router.navigate(['/subject/subject-list'])
      },
      error => {
        // this.toastService.show('Subject is not saved: ' + (typeof error.error === 'string'? error.error : error.mesage ) , {header:'Saving subject', classname: 'bg-danger text-light'});
      }

    );
  }



}
