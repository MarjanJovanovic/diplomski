import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { StudentService } from 'src/app/core/service/student.service';
import { StudentDto } from 'src/app/core/models/student.model';
import { StudentDetailsComponent } from '../student-details/student-details.component';
import { StudentAddComponent } from '../student-add/student-add.component';

const DISPLAYED_COLUMNS = [
  'id',
  'firstName',
  'email',
  'address',
  'city',

  'indexNumber',
  'currentYearOfStudy',
  'indexYear',
  'infoButton',
  'editButton',
  'deleteButton',
];

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) public paginator: MatPaginator;
  @ViewChild(MatSort) public sort: MatSort;

  public totalItems: number;

  public dataSource: MatTableDataSource<StudentDto>;
  public displayedColumns: string[] = DISPLAYED_COLUMNS;

  public destroy$: Subject<boolean> = new Subject();

  constructor(
    private readonly studentService: StudentService,
    public readonly dialog: MatDialog
  ) {}

  ngAfterViewInit() {
    this.fetchTableElements();
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public fetchTableElements(pageNumber: number = 0, pageSize = 5): void {
    this.studentService
      .getByPage(pageNumber, pageSize)
      .pipe(takeUntil(this.destroy$))
      .subscribe((res) => {
        this.totalItems = res.totalElements;
        this.dataSource = new MatTableDataSource(res.content);
      });
  }

  public applyFilter(event: Event): void {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public openDetailsModal(student: StudentDto): void {
    this.dialog.open(StudentDetailsComponent, {
      data: {
        student: student,
      },
    });
  }

  public openEditModel(student: StudentDto): void {
    this.dialog
      .open(StudentAddComponent, {
        data: {
          student: student,
          isEditMode: true,
        },
      })
      .afterClosed()
      .subscribe((res) => {
        if (res) {
          this.studentService
            .update(res.student)
            .pipe(takeUntil(this.destroy$))
            .subscribe(() => {
              this.fetchTableElements();
            });
        }
      });
  }

  public deleteStudent(student: StudentDto): void {
    this.studentService
      .delete(student)
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.fetchTableElements(
          this.paginator.pageIndex,
          this.paginator.pageSize
        );
      });
  }

  public addStudent(): void {
    this.dialog
      .open(StudentAddComponent, {
        data: {
          isEditModal: false,
          student: {
            name: null,
            description: null,
            noOfEsp: null,
            yearOfStudy: null,
            semester: null,
          },
        },
      })
      .afterClosed()
      .pipe(takeUntil(this.destroy$))
      .subscribe((res) => {
        if (res) {
          this.studentService.save(res.student).subscribe(() => {
            this.fetchTableElements();
          });
        }
      });
  }

  public onPageChange(pageChangeEvent: PageEvent): void {
    this.fetchTableElements(
      pageChangeEvent.pageIndex,
      pageChangeEvent.pageSize
    );
  }
}
