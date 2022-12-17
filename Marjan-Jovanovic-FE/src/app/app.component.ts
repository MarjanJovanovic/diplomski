import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { Roles } from './core/enums/roles';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Marjan-Jovanovic-FE';
  isLoggedIn: boolean = true;
  isAdmin: boolean = false;
  isProfessor: boolean = false;
  isStudent: boolean = false;
  userProfile: KeycloakProfile | null = null;
  constructor(
    private keycloakService: KeycloakService,
    private router: Router
  ) {
    // keycloakService.isLoggedIn().then(res =>{
    //   this.isLoggedIn = res;
    // });
    // router.events.subscribe((val) => {
    //   console.log("loggers")
    //   console.log("is professor: ", keycloakService.isUserInRole('ROLE_PROFESSOR'));
    //   console.log("is admin: ", keycloakService.isUserInRole('ROLE_ADMIN'));
    // });
  }

  public async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.keycloakService.isLoggedIn();

    // type userRoles = Array<{id: number, text: string}>;
    if (this.isLoggedIn) {
      this.userProfile = await this.keycloakService.loadUserProfile();
      this.isAdmin = this.keycloakService.isUserInRole(Roles.ADMIN);
      this.isProfessor = this.keycloakService.isUserInRole(Roles.PROFESSOR);
      this.isStudent = this.keycloakService.isUserInRole(Roles.STUDENT);
    }

    console.log('iis logged in???', this.isLoggedIn);
    console.log('profile: ', this.userProfile);
    console.log('is admin?: ', this.keycloakService.isUserInRole('ROLE_ADMIN'));
    console.log(
      'is professor?: ',
      this.keycloakService.isUserInRole('ROLE_PROFESSOR')
    );
    console.log('get user roles', this.keycloakService.getUserRoles());
    console.log('token', this.keycloakService.getToken());
  }

  login() {
    this.keycloakService.login();
  }

  logout() {
    this.keycloakService.logout();
  }

  // isLoggedIn(){
  //   return keycloakService.isLoggedIn();
  // }

  @ViewChild('sidenav') sidenav: MatSidenav;
  isExpanded = true;
  showSubmenu: boolean = false;
  isShowing = false;
  showSubSubMenu: boolean = false;

  mouseenter() {
    // if (!this.isExpanded) {
    //   this.isShowing = true;
    // }
    // console.log("mouse enter");
    // console.log("is admin?: ", this.keycloakService.isUserInRole("ROLE_ADMIN"));
    // console.log("is professor?: ", this.keycloakService.isUserInRole("ROLE_PROFESSOR"));
  }

  mouseleave() {
    if (!this.isExpanded) {
      this.isShowing = false;
    }
  }
}
