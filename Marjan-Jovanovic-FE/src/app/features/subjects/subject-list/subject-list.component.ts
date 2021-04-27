import { Component, OnInit } from '@angular/core';
import {AfterViewInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { Subject } from 'src/app/core/models/subject.model';
import { SubjectService } from 'src/app/core/service/subject.service';

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

  public displayedColumns: string[] = ['id', 'name', 'description', 'noOfEsp', 'yearOfStudy', 'semester', 'professors'];
  public dataSource: MatTableDataSource<Subject>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private subjectService: SubjectService ) {


  }

  ngAfterViewInit() {
    // this.dataSource.sort = this.sort;
    this.subjectService.getAll().subscribe((res) => {
      console.log(res);
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

}

