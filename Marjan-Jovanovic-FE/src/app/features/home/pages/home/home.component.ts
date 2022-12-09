import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { Roles } from 'src/app/core/enums/roles';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isLoggedIn: boolean;
  isAdmin: boolean = false;
  isProfessor: boolean = false;
  isStudent: boolean = false;
  userProfile: KeycloakProfile|null = null;

  constructor(private keycloakService: KeycloakService) { }

  public async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.keycloakService.isLoggedIn();

    // type userRoles = Array<{id: number, text: string}>;
    if (this.isLoggedIn){
      this.userProfile = await this.keycloakService.loadUserProfile();
      this.isAdmin = this.keycloakService.isUserInRole(Roles.ADMIN);
      this.isProfessor = this.keycloakService.isUserInRole(Roles.PROFESSOR);
      this.isStudent = this.keycloakService.isUserInRole(Roles.STUDENT);
    }

  }

}
