import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SubjectDto } from 'src/app/core/models/subject.model';
import { SubjectService } from 'src/app/core/service/subject.service';
import { MatDialog } from '@angular/material/dialog';
import { SubjectAddComponent } from '../subject-add/subject-add.component';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { SubjectDetailsComponent } from '../subject-details/subject-details.component';

const DISPLAYED_COLUMNS = [
  'id',
  'name',
  'description',
  'noOfEsp',
  'yearOfStudy',
  'semester',
  // 'professors',
  'infoButton',
  'editButton',
  'deleteButton',
];

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css'],
})
export class SubjectListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) public paginator: MatPaginator;
  @ViewChild(MatSort) public sort: MatSort;

  public totalItems: number;

  public dataSource: MatTableDataSource<SubjectDto>;
  public displayedColumns: string[] = DISPLAYED_COLUMNS;

  public destroy$: Subject<boolean> = new Subject();

  constructor(
    private readonly subjectService: SubjectService,
    public readonly dialog: MatDialog
  ) {}

  ngAfterViewInit() {
    this.fetchTableElements();
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public fetchTableElements(pageNumber: number = 0, pageSize = 5): void {
    this.subjectService
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

  public openDetailsModal(subject: SubjectDto): void {
    this.dialog.open(SubjectDetailsComponent, {
      data: {
        subject: subject,
      },
    });
  }

  public openEditModel(subject: SubjectDto): void {
    this.dialog
      .open(SubjectAddComponent, {
        data: {
          subject: subject,
          isEditMode: true,
        },
      })
      .afterClosed()
      .subscribe((res) => {
        if (res) {
          this.subjectService
            .update(res.subject)
            .pipe(takeUntil(this.destroy$))
            .subscribe(() => {
              this.fetchTableElements();
            });
        }
      });
  }

  public deleteSubject(subject: SubjectDto): void {
    this.subjectService
      .delete(subject)
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.fetchTableElements(
          this.paginator.pageIndex,
          this.paginator.pageSize
        );
      });
  }

  public addSubject(): void {
    this.dialog
      .open(SubjectAddComponent, {
        data: {
          isEditModal: false,
          subject: {
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
          this.subjectService.save(res.subject).subscribe(() => {
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
