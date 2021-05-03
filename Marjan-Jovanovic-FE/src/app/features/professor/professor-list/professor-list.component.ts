import { Component, OnInit } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { takeUntil } from 'rxjs/operators';
import { ProfessorDto } from 'src/app/core/models/professor.model';
import { Subject } from 'rxjs';
import { ProfessorService } from 'src/app/core/service/professor.service';
import { ProfessorDetailsComponent } from '../professor-details/professor-details.component';
import { ProfessorAddComponent } from '../professor-add/professor-add.component';

const DISPLAYED_COLUMNS = [
  'id',
  'firstName',
  'lastName',
  'email',
  'address',
  'city',

  'phone',
  'reelectionDate',
  'title',
  'subjects',
];

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.css'],
})
export class ProfessorListComponent implements AfterViewInit {
  @ViewChild(MatPaginator) public paginator: MatPaginator;
  @ViewChild(MatSort) public sort: MatSort;

  public totalItems: number;

  public dataSource: MatTableDataSource<ProfessorDto>;
  public displayedColumns: string[] = DISPLAYED_COLUMNS;

  public destroy$: Subject<boolean> = new Subject();

  constructor(
    private readonly professorService: ProfessorService,
    public readonly dialog: MatDialog
  ) {}

  ngAfterViewInit() {
    this.fetchTableElements();
  }

  ngOnDestroy() {
    this.destroy$.next(true);
  }

  public fetchTableElements(pageNumber: number = 0, pageSize = 5): void {
    this.professorService
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

  public openDetailsModal(professor: ProfessorDto): void {
    this.dialog.open(ProfessorDetailsComponent, {
      data: {
        professor: professor,
      },
    });
  }

  public openEditModel(professor: ProfessorDto): void {
    this.dialog
      .open(ProfessorAddComponent, {
        data: {
          professor: professor,
          isEditMode: true,
        },
      })
      .afterClosed()
      .subscribe((res) => {
        if (res) {
          this.professorService
            .update(res.professor)
            .pipe(takeUntil(this.destroy$))
            .subscribe(() => {
              this.fetchTableElements();
            });
        }
      });
  }

  public deleteSubject(professor: ProfessorDto): void {
    this.professorService
      .delete(professor)
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.fetchTableElements(
          this.paginator.pageIndex,
          this.paginator.pageSize
        );
      });
  }

  public addProfessor(): void {
    this.dialog
      .open(ProfessorAddComponent, {
        data: {
          isEditModal: false, //TODO
          professor: {
            id: 0,
            firstName: null,
            lastName: null,
            email: null,
            address: null,
            city: null,

            phone: null,
            reelectionDate: null,
            title: null,
            subjects: null,
          },
        },
      })
      .afterClosed()
      .pipe(takeUntil(this.destroy$))
      .subscribe((res) => {
        if (res) {
          this.professorService.save(res.professor).subscribe(() => {
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
