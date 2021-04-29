import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';


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

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.subjectAddForm = this.formBuilder.group({
      id: '',
      name: '',
      description: '',
      noOfEsp: '',
      yearOfStudy: '',
      semester: ''
    })

    this.subjectAddForm.valueChanges.subscribe(console.log);
  }

}
