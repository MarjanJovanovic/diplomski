import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { ExamPeriodDto } from 'src/app/core/models/exam-period.model';
import { ExamPeriodService } from 'src/app/core/service/exam-period.service';
import { ExamPeriodAddComponent } from '../exam-period-add/exam-period-add.component';
import { ExamPeriodDetailsComponent } from '../exam-period-details/exam-period-details.component';

const DISPLAYED_COLUMNS = [
  'id',
  'name',
  'startDate',
  'endDate',
  'isActive',

  'infoButton',
  'editButton',
  'deleteButton',
];

@Component({
  selector: 'app-exam-period-list',
  templateUrl: './exam-period-list.component.html',
  styleUrls: ['./exam-period-list.component.css'],
})
export class ExamPeriodListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) public paginator: MatPaginator;
  @ViewChild(MatSort) public sort: MatSort;

  public totalItems: number;

  public dataSource: MatTableDataSource<ExamPeriodDto>;
  public displayedColumns: string[] = DISPLAYED_COLUMNS;

  public destroy$: Subject<boolean> = new Subject();

  constructor(
    private readonly examPeriodService: ExamPeriodService,
    public readonly dialog: MatDialog
  ) {}

  ngAfterViewInit() {
    this.fetchTableElements();
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public fetchTableElements(pageNumber: number = 0, pageSize = 5): void {
    this.examPeriodService
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

  public openDetailsModal(examPeriod: ExamPeriodDto): void {
    this.dialog.open(ExamPeriodDetailsComponent, {
      data: {
        examPeriod: examPeriod,
      },
    });
  }

  public openEditModel(examPeriod: ExamPeriodDto): void {
    this.dialog
      .open(ExamPeriodAddComponent, {
        data: {
          examPeriod: examPeriod,
          isEditMode: true,
        },
      })
      .afterClosed()
      .subscribe((res) => {
        if (res) {
          this.examPeriodService
            .update(res.examPeriod)
            .pipe(takeUntil(this.destroy$))
            .subscribe(() => {
              this.fetchTableElements();
            });
        }
      });
  }

  public deleteExamPeriod(examPeriod: ExamPeriodDto): void {
    this.examPeriodService
      .delete(examPeriod)
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.fetchTableElements(
          this.paginator.pageIndex,
          this.paginator.pageSize
        );
      });
  }

  public addExamPeriod(): void {
    this.dialog
      .open(ExamPeriodAddComponent, {
        data: {
          isEditModal: false,
          examPeriod: {
            id: null,
            name: null,
            startDate: null,
            endDate: null,
            isActive: null,
          },
        },
      })
      .afterClosed()
      .pipe(takeUntil(this.destroy$))
      .subscribe((res) => {
        if (res) {
          this.examPeriodService.save(res.examPeriod).subscribe(() => {
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
