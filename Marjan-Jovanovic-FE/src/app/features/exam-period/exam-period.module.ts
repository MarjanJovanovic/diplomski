import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExamPeriodRoutingModule } from './exam-period-routing.module';
import { ExamPeriodListComponent } from './exam-period-list/exam-period-list.component';
import { ExamPeriodAddComponent } from './exam-period-add/exam-period-add.component';
import { ExamPeriodDetailsComponent } from './exam-period-details/exam-period-details.component';

import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FlexLayoutModule } from '@angular/flex-layout';

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
    ExamPeriodListComponent,
    ExamPeriodAddComponent,
    ExamPeriodDetailsComponent,
  ],
  imports: [CommonModule, ExamPeriodRoutingModule, MATERIAL_MODULES],
})
export class ExamPeriodModule {}
