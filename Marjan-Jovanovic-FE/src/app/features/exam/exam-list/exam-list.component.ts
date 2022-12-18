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
import { KeycloakProfile } from 'keycloak-js';
import { KeycloakService } from 'keycloak-angular';
import { Roles } from 'src/app/core/enums/roles';

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

  isLoggedIn: boolean;
  isAdmin: boolean = false;
  isProfessor: boolean = false;
  isStudent: boolean = false;
  userProfile: KeycloakProfile | null = null;

  constructor(
    private readonly examService: ExamService,
    public readonly dialog: MatDialog,
    private keycloakService: KeycloakService
  ) {}

  public async ngAfterViewInit() {
    this.fetchTableElements();

    this.isLoggedIn = await this.keycloakService.isLoggedIn();

    // type userRoles = Array<{id: number, text: string}>;
    if (this.isLoggedIn) {
      this.userProfile = await this.keycloakService.loadUserProfile();
      this.isAdmin = this.keycloakService.isUserInRole(Roles.ADMIN);
      this.isProfessor = this.keycloakService.isUserInRole(Roles.PROFESSOR);
      this.isStudent = this.keycloakService.isUserInRole(Roles.STUDENT);
    }
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

  public showSuccess(): void {}

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
