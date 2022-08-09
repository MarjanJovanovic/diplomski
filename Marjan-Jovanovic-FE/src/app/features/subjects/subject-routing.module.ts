import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubjectAddComponent } from './subject-add/subject-add.component';
import { SubjectDetailsComponent } from './subject-details/subject-details.component';
import { SubjectListComponent } from './subject-list/subject-list.component';

const routes: Routes = [
  { path: 'subject-list', component: SubjectListComponent },
  { path: 'subject-add', component: SubjectAddComponent },
  { path: 'subject-details', component: SubjectDetailsComponent },
  { path: '', redirectTo: 'subject-list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SubjectRoutingModule {}
