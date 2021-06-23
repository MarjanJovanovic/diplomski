import { NgModule } from '@angular/core';

import { SubjectRoutingModule } from './subject-routing.module';
import { SubjectListComponent } from './subject-list/subject-list.component';
import { SubjectAddComponent } from './subject-add/subject-add.component';
import { SubjectDetailsComponent } from './subject-details/subject-details.component';
import {
  ErrorStateMatcher,
  ShowOnDirtyErrorStateMatcher,
} from '@angular/material/core';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    SubjectListComponent,
    SubjectAddComponent,
    SubjectDetailsComponent,
  ],
  imports: [SubjectRoutingModule, SharedModule],
  providers: [
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher },
  ],
})
export class SubjectModule {}
