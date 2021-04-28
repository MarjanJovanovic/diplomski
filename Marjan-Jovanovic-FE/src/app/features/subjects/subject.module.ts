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
import { SubjectEditComponent } from './subject-edit/subject-edit.component';
import { ErrorStateMatcher, ShowOnDirtyErrorStateMatcher } from '@angular/material/core';
import { ReactiveFormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';



@NgModule({
  declarations: [
    SubjectListComponent,
    SubjectAddComponent,
    SubjectEditComponent
  ],
  imports: [
    CommonModule,
    SubjectRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatSortModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule
  ],
  providers: [
    {provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher}
  ]

})
export class SubjectModule { }
