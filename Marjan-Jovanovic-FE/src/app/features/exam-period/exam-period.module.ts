import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExamPeriodRoutingModule } from './exam-period-routing.module';
import { ExamPeriodListComponent } from './exam-period-list/exam-period-list.component';
import { ExamPeriodAddComponent } from './exam-period-add/exam-period-add.component';
import { ExamPeriodDetailsComponent } from './exam-period-details/exam-period-details.component';
import {
  ErrorStateMatcher,
  ShowOnDirtyErrorStateMatcher,
} from '@angular/material/core';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [
    ExamPeriodListComponent,
    ExamPeriodAddComponent,
    ExamPeriodDetailsComponent,
  ],
  imports: [ExamPeriodRoutingModule, SharedModule],
  providers: [
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher },
  ],
})
export class ExamPeriodModule {}
