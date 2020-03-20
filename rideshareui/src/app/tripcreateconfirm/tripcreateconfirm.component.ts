import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import {User} from '../model/user';
import { Trip } from '../model/Trip';

@Component({
  selector: 'app-tripcreateconfirm',
  templateUrl: './tripcreateconfirm.component.html',
  styleUrls: ['./tripcreateconfirm.component.css']
})
export class TripcreateconfirmComponent {

  public user = new User();
  public trip = new Trip();

  constructor(private router:Router, private activatedRoute:ActivatedRoute ) { 

  this.trip = this.router.getCurrentNavigation().extras.state as Trip;
  this.user = JSON.parse(localStorage.getItem("user"));

  }

  home(){
    this.router.navigateByUrl('/dashboard', { state: this.user});  
  }

}

