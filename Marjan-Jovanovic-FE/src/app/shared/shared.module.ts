import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './components/input-field/input-field.component';
import { SnackbarComponent } from './components/snackbar/snackbar.component';



@NgModule({
  declarations: [
    InputFieldComponent,
    SnackbarComponent
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
