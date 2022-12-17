import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FaqHelpComponent } from './faq-help/faq-help.component';

const routes: Routes = [
  { path: 'faq-help', component: FaqHelpComponent },
  { path: '', redirectTo: 'faq-help', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FaqRoutingModule {}
