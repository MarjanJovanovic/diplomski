import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExamPeriodAddComponent } from './exam-period-add/exam-period-add.component';
import { ExamPeriodDetailsComponent } from './exam-period-details/exam-period-details.component';
import { ExamPeriodListComponent } from './exam-period-list/exam-period-list.component';

const routes: Routes = [
  { path: 'exam-period-list', component: ExamPeriodListComponent },
  { path: 'exam-period-add', component: ExamPeriodAddComponent },
  { path: 'exam-period-details', component: ExamPeriodDetailsComponent },
  { path: '', redirectTo: 'exam-period-list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ExamPeriodRoutingModule {}
