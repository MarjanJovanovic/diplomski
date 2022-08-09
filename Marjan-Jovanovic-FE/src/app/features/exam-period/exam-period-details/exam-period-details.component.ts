import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ExamPeriodDto } from 'src/app/core/models/exam-period.model';
import { SubjectDetailsComponent } from '../../subjects/subject-details/subject-details.component';

interface ExamPeriodDetailsData {
  examPeriod: ExamPeriodDto;
}

@Component({
  selector: 'app-exam-period-details',
  templateUrl: './exam-period-details.component.html',
  styleUrls: ['./exam-period-details.component.css']
})
export class ExamPeriodDetailsComponent implements OnInit {
  public examPeriod: ExamPeriodDto;
  constructor(
    private readonly dialogRef: MatDialogRef<SubjectDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ExamPeriodDetailsData
  ) {}

  ngOnInit(): void {
    this.examPeriod = this.data.examPeriod;
    console.log(this.examPeriod);
  }
}
