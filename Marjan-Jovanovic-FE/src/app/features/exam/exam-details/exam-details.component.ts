import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ExamDto } from 'src/app/core/models/exam.model';
import { SubjectDetailsComponent } from '../../subjects/subject-details/subject-details.component';

interface ExamDetailsData {
  exam: ExamDto;
}

@Component({
  selector: 'app-exam-details',
  templateUrl: './exam-details.component.html',
  styleUrls: ['./exam-details.component.css'],
})
export class ExamDetailsComponent implements OnInit {
  public exam: ExamDto;
  constructor(
    private readonly dialogRef: MatDialogRef<SubjectDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ExamDetailsData
  ) {}

  ngOnInit(): void {
    this.exam = this.data.exam;
    console.log(this.exam);
  }
}
