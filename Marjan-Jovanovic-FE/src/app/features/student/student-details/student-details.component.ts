import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { StudentDto } from 'src/app/core/models/student.model';
import { ProfessorDetailsComponent } from '../../professor/professor-details/professor-details.component';

interface StudentDetailsData {
  student: StudentDto;
}

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  public student: StudentDto;
  constructor(
    private readonly dialogRef: MatDialogRef<ProfessorDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: StudentDetailsData
  ) {}

  ngOnInit(): void {
    this.student = this.data.student;
    console.log(this.student);
  }
}
