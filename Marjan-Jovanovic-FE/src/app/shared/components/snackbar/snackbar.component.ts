import { Component, OnInit } from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';

@Component({
  selector: 'app-snackbar',
  templateUrl: './snackbar.component.html',
  styleUrls: ['./snackbar.component.css']
})
export class SnackbarComponent implements OnInit {

  constructor(private _snackBar: MatSnackBar) { }

  openSnackBarWithButton(message: string, action: string) {
    this._snackBar.open(message, action);
  }

  openTimedSnackBar(message: string, action: string = 'Dismiss', durationInSeconds: number = 5) {
    let config = new MatSnackBarConfig();
    config.duration = durationInSeconds * 1000;
    this._snackBar.open(message, action, config);
  }


  ngOnInit(): void {
  }

}
