import { NgModule } from '@angular/core';

import { ExamRoutingModule } from './exam-routing.module';
import { ExamListComponent } from './exam-list/exam-list.component';
import { ExamAddComponent } from './exam-add/exam-add.component';
import { ExamDetailsComponent } from './exam-details/exam-details.component';
import {
  ErrorStateMatcher,
  ShowOnDirtyErrorStateMatcher,
} from '@angular/material/core';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [ExamListComponent, ExamAddComponent, ExamDetailsComponent],
  imports: [ExamRoutingModule, SharedModule],
  providers: [
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher },
  ],
})
export class ExamModule { }
