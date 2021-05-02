import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/home/pages/home/home.component';
import { ProfessorModule } from './features/professor/professor.module';
import { SubjectAddComponent } from './features/subjects/subject-add/subject-add.component';
import { SubjectListComponent } from './features/subjects/subject-list/subject-list.component';
import { SubjectModule } from './features/subjects/subject.module';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'subject', component: SubjectModule },
  {
    path: 'professor',
    loadChildren: () =>
      import('./features/professor/professor.module').then(
        (m) => m.ProfessorModule
      ),
  },

  // {path: 'subject-list', component: SubjectListComponent},
  // {path: 'subject-add', component: SubjectAddComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
