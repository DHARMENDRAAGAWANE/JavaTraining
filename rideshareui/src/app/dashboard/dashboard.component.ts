import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { map, filter} from 'rxjs/operators';
import {User} from '../model/user';
import {VehicleService} from '../service/vehicle.service'


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  public user = new User();
  public vehicle =[] ;
  constructor(private vehicleService:VehicleService,private router:Router, private activatedRoute:ActivatedRoute) { 
    console.log(this.router.getCurrentNavigation().extras.state);
    this.user = this.router.getCurrentNavigation().extras.state as User;

    if(!this.router.getCurrentNavigation().extras.state || !this.user || !this.user.username){
      this.router.navigateByUrl('/login');  
    } else
    {

    console.log("print  " + this.user.username);

    vehicleService.searchVehicals(this.user).
    subscribe(data => {
      this.vehicle=data;     
      }   
               
    );
    }
  }

  driving() {

    
    if(!this.vehicle || !this.vehicle.length){
      this.router.navigateByUrl('/vehicle', { state: this.user });  
    }else {
    this.router.navigateByUrl('/drivertrip', { state: this.user });  
    }
  }

  riding(){
    this.router.navigateByUrl('/needtrip', { state: this.user });  
  }
      
  }


