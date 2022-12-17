import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FaqHelpComponent } from './faq-help/faq-help.component';
import { FaqRoutingModule } from './faq-routing.module';

@NgModule({
  declarations: [FaqHelpComponent],
  imports: [CommonModule, FaqRoutingModule],
})
export class FaqModule {}
