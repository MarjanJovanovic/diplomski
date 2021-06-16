import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';

import { SubjectRoutingModule } from './subject-routing.module';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSortModule } from '@angular/material/sort';
import { SubjectAddComponent } from './subject-add/subject-add.component';
import {
  ErrorStateMatcher,
  ShowOnDirtyErrorStateMatcher,
} from '@angular/material/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SubjectDetailsComponent } from './subject-details/subject-details.component';
import { SnackbarComponent } from 'src/app/shared/components/snackbar/snackbar.component';

const MATERIAL_MODULES = [
  MatTableModule,
  MatPaginatorModule,
  MatFormFieldModule,
  MatSortModule,
  MatInputModule,
  ReactiveFormsModule,
  MatSelectModule,
  MatButtonModule,
  MatIconModule,
  MatDialogModule,
  FlexLayoutModule,
];

@NgModule({
  declarations: [
    SubjectListComponent,
    SubjectAddComponent,
    SubjectDetailsComponent,
    SnackbarComponent
  ],
  imports: [CommonModule, SubjectRoutingModule, MATERIAL_MODULES, ],
  providers: [
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher },
  ],
})
export class SubjectModule {}
