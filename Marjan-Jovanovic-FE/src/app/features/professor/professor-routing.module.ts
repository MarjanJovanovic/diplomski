import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfessorAddComponent } from './professor-add/professor-add.component';
import { ProfessorDetailsComponent } from './professor-details/professor-details.component';
import { ProfessorListComponent } from './professor-list/professor-list.component';

const routes: Routes = [
  { path: 'professor-list', component: ProfessorListComponent },
  { path: 'professor-add', component: ProfessorAddComponent },
  { path: 'professor-details', component: ProfessorDetailsComponent },
  { path: '', redirectTo: 'professor-list', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfessorRoutingModule {}
