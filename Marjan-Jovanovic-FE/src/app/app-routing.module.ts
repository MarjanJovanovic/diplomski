import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/auth/auth.guard';
import { AccessDeniedComponent } from './features/access-denied/access-denied.component';
import { AdminComponent } from './features/admin/admin.component';
import { HomeComponent } from './features/home/pages/home/home.component';
import { ManagerComponent } from './features/manager/manager.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  // { path: 'subject', component: SubjectModule },
  {
    path: 'subject',
    loadChildren: () =>
      import('./features/subjects/subject.module').then((m) => m.SubjectModule),
  },
  // { path: 'professor', component: ProfessorModule },
  {
    path: 'professor',
    loadChildren: () =>
      import('./features/professor/professor.module').then(
        (m) => m.ProfessorModule
      ),
  },
  {
    path: 'student',
    loadChildren: () =>
      import('./features/student/student.module').then((m) => m.StudentModule),
  },
  {
    path: 'exam-period',
    loadChildren: () =>
      import('./features/exam-period/exam-period.module').then(
        (m) => m.ExamPeriodModule
      ),
  },
  {
    path: 'exam',
    loadChildren: () =>
      import('./features/exam/exam.module').then((m) => m.ExamModule),
  },
  {
    path: 'access-denied',
    component: AccessDeniedComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_ADMIN'] },
  },
  {
    path: 'manager',
    component: ManagerComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_MANAGER'] },
  },

  // {path: 'subject-list', component: SubjectListComponent},
  // {path: 'subject-add', component: SubjectAddComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
