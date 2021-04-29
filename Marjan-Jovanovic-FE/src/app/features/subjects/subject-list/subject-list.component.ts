import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SubjectDto } from 'src/app/core/models/subject.model';
import { SubjectService } from 'src/app/core/service/subject.service';
import { MatDialog } from '@angular/material/dialog';
import { SubjectAddComponent } from '../subject-add/subject-add.component';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';


export interface UserData {
  id: string;
  name: string;
  progress: string;
  color: string;
}

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements AfterViewInit {

  subjects: SubjectDto[];

  public displayedColumns: string[] = ['id', 'name', 'description', 'noOfEsp', 'yearOfStudy', 'semester', 'professors' , 'editButton', 'deleteButton'];
  public dataSource: MatTableDataSource<SubjectDto>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  destroy$: Subject<boolean> = new Subject();

  constructor(private subjectService: SubjectService, public dialog: MatDialog) {


  }

  ngAfterViewInit() {
    // this.dataSource.sort = this.sort;
    this.fetchTableElements();

  }

  fetchTableElements(){
    this.subjectService.getAll()
    .pipe(takeUntil(this.destroy$))
    .subscribe((res) => {
      console.log(res);
      this.subjects = res;
      this.dataSource = new MatTableDataSource(res);
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource);
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openEditModel(subject: SubjectDto){
    this.dialog.open(SubjectAddComponent, {
      data: {
        subject: subject,
        // height: '400px',
        // width: '1600px',
      }
    });
  }

  deleteSubject(subject: SubjectDto){
    this.subjectService.delete(subject).subscribe((res)=>{console.log(res);
    });
    console.log('deleting...', subject);
    this.fetchTableElements();
  }

}

