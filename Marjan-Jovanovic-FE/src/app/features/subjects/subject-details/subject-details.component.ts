import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Subject } from 'rxjs';
import { SubjectDto } from 'src/app/core/models/subject.model';

interface SubjectDetailsData {
  subject: SubjectDto;
}

@Component({
  selector: 'app-subject-details',
  templateUrl: './subject-details.component.html',
  styleUrls: ['./subject-details.component.css'],
})
export class SubjectDetailsComponent implements OnInit {
  public subject: SubjectDto;
  constructor(
    private readonly dialogRef: MatDialogRef<SubjectDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SubjectDetailsData
  ) {}

  ngOnInit(): void {
    this.subject = this.data.subject;
    console.log(this.subject);
  }
}
