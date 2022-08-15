import { NgModule } from '@angular/core';

import { ProfessorRoutingModule } from './professor-routing.module';
import { ProfessorAddComponent } from './professor-add/professor-add.component';
import { ProfessorListComponent } from './professor-list/professor-list.component';
import { ProfessorDetailsComponent } from './professor-details/professor-details.component';
import {
  ErrorStateMatcher,
  ShowOnDirtyErrorStateMatcher,
} from '@angular/material/core';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [
    ProfessorAddComponent,
    ProfessorListComponent,
    ProfessorDetailsComponent,
  ],
  imports: [ProfessorRoutingModule, SharedModule],
  providers: [
    { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher },
  ],
})
export class ProfessorModule {}
