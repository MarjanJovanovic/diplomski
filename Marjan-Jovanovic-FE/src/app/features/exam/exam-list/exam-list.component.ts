import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { ExamDto } from 'src/app/core/models/exam.model';
import { ExamService } from 'src/app/core/service/exam.service';
import { ExamDetailsComponent } from '../exam-details/exam-details.component';
import { ExamAddComponent } from '../exam-add/exam-add.component';

const DISPLAYED_COLUMNS = [
  'id',
  'date',
  'examPeriod',
  'professor',
  'subject',

  'infoButton',
  'editButton',
  'deleteButton',
];

@Component({
  selector: 'app-exam-list',
  templateUrl: './exam-list.component.html',
  styleUrls: ['./exam-list.component.css'],
})
export class ExamListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) public paginator: MatPaginator;
  @ViewChild(MatSort) public sort: MatSort;

  public totalItems: number;

  public dataSource: MatTableDataSource<ExamDto>;
  public displayedColumns: string[] = DISPLAYED_COLUMNS;

  public destroy$: Subject<boolean> = new Subject();

  constructor(
    private readonly examService: ExamService,
    public readonly dialog: MatDialog
  ) {}

  ngAfterViewInit() {
    this.fetchTableElements();
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public fetchTableElements(pageNumber: number = 0, pageSize = 5): void {
    this.examService
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

  public openDetailsModal(exam: ExamDto): void {
    this.dialog.open(ExamDetailsComponent, {
      data: {
        exam: exam,
      },
    });
  }

  public openEditModel(exam: ExamDto): void {
    this.dialog
      .open(ExamAddComponent, {
        data: {
          exam: exam,
          isEditMode: true,
        },
      })
      .afterClosed()
      .subscribe((res) => {
        if (res) {
          console.log('Res', res);

          this.examService
            .update(res.subject)
            .pipe(takeUntil(this.destroy$))
            .subscribe(() => {
              this.fetchTableElements();
            });
        }
      });
    console.log(this.dataSource);
  }

  public deleteExam(exam: ExamDto): void {
    this.examService
      .delete(exam)
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.fetchTableElements(
          this.paginator.pageIndex,
          this.paginator.pageSize
        );
      });
  }

  public addExam(): void {
    this.dialog
      .open(ExamAddComponent, {
        data: {
          isEditModal: false,
          exam: {
            id: null,
            date: null,
            examPeriod: null,
            professor: null,
            subject: null,
          },
        },
      })
      .afterClosed()
      .pipe(takeUntil(this.destroy$))
      .subscribe((res) => {
        if (res) {
          this.examService.save(res.subject).subscribe(() => {
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
