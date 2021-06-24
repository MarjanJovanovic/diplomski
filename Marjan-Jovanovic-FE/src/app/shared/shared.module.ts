import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './components/input-field/input-field.component';
import { SnackbarComponent } from './components/snackbar/snackbar.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CoreModule } from '../core';
import { MatNativeDateModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { SpinnerComponent } from './components/spinner/spinner.component';



const MATERIAL_MODULES = [
  MatTableModule,
  MatPaginatorModule,
  MatFormFieldModule,
  MatSortModule,
  MatInputModule,
  ReactiveFormsModule,
  MatSelectModule,
  MatButtonModule,
  MatIconModule,
  MatDialogModule,
  FlexLayoutModule,
  MatSnackBarModule,
  MatCheckboxModule,
  MatDatepickerModule,
  MatNativeDateModule,
  // MatMomentDateModule,
  MatCardModule,
  MatProgressSpinnerModule,
];


@NgModule({
  declarations: [
    InputFieldComponent,
    SnackbarComponent,
    SpinnerComponent
  ],
  imports: [
    CommonModule, MATERIAL_MODULES, CoreModule
  ],
  exports: [
    SnackbarComponent, MATERIAL_MODULES, CommonModule, SpinnerComponent
  ]
})
export class SharedModule { }
