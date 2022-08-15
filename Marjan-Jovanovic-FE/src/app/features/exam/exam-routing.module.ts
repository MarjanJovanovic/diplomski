import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExamAddComponent } from './exam-add/exam-add.component';
import { ExamDetailsComponent } from './exam-details/exam-details.component';
import { ExamListComponent } from './exam-list/exam-list.component';

const routes: Routes = [
  { path: 'exam-list', component: ExamListComponent },
  { path: 'exam-add', component: ExamAddComponent },
  { path: 'exam-details', component: ExamDetailsComponent },
  { path: '', redirectTo: 'exam-list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ExamRoutingModule {}
