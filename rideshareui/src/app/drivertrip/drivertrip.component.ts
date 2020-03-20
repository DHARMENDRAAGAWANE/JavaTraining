import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { map, filter} from 'rxjs/operators';
import {User} from '../model/user';
import { Vehicle } from '../model/vehicle';
import {VehicleService} from '../service/vehicle.service';
import {TripService} from '../service/trip.service';
import { Trip } from '../model/Trip';

@Component({
  selector: 'app-drivertrip',
  templateUrl: './drivertrip.component.html',
  styleUrls: ['./drivertrip.component.css']
})
export class DrivertripComponent{
  public vehicle = new Vehicle(); 
  public user = new User();
  public trip = new Trip();
  constructor(private vehicleService:VehicleService,private tripService:TripService,private router:Router, private activatedRoute:ActivatedRoute ) { 

    console.log(this.router.getCurrentNavigation().extras.state);
    this.user = this.router.getCurrentNavigation().extras.state as User;
    localStorage.setItem("user", JSON.stringify(this.user));
    
    if(!this.router.getCurrentNavigation().extras.state || !this.user || !this.user.username){
      this.router.navigateByUrl('/login');  
    }

    vehicleService.searchVehicals(this.user).
    subscribe(data => {
      this.vehicle=data[0];     
      this.trip.vehicle=this.vehicle;
      this.trip.user=this.user;
      }   
               
    );

  }

  home(){
    this.router.navigateByUrl('/dashboard', { state: this.user});  
  }

  createTrip(){
    this.trip.user=this.user;
    this.tripService.saveTrip(this.trip).subscribe(data => {
    this.trip=data;        
    this.router.navigateByUrl('/tripcreateconfirm', { state: this.trip});  
      }   
               
    );
  }

}
