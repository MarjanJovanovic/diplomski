import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProfessorDto } from 'src/app/core/models/professor.model';
import { SubjectDetailsComponent } from '../../subjects/subject-details/subject-details.component';

interface ProfessorDetailsData {
  professor: ProfessorDto;
}

@Component({
  selector: 'app-professor-details',
  templateUrl: './professor-details.component.html',
  styleUrls: ['./professor-details.component.css'],
})
export class ProfessorDetailsComponent implements OnInit {
  public professor: ProfessorDto;
  constructor(
    private readonly dialogRef: MatDialogRef<SubjectDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ProfessorDetailsData
  ) {}

  ngOnInit(): void {
    this.professor = this.data.professor;
    console.log(this.professor);
  }
}
