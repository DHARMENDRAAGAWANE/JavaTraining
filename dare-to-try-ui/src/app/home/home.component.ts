import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../models/user';
import {  AuthenticationService } from '../service/authentication.service';
import { UserService } from '../service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser: User;
  users = [];

  constructor(
      private authenticationService: AuthenticationService,
      private userService: UserService,private router: Router
  ) {
    if(!this.authenticationService.currentUserValue){
      this.router.navigateByUrl('/login');  
    }
      this.currentUser = this.authenticationService.currentUserValue;
  }

  ngOnInit() {
      this.loadAllUsers();
  }

  deleteUser(id: number) {
      this.userService.delete(id)
          .pipe(first())
          .subscribe(() => this.loadAllUsers());
  }

  private loadAllUsers() {
      this.userService.getAll()
          .pipe(first())
          .subscribe(users => this.users = users);
  }
}