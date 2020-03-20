import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import {User} from '../model/user';
import {RideDetails} from '../model/rideDetails';
import {RiderService} from '../service/rider.service';
import {Trip} from '../model/trip';
import {TripService} from '../service/trip.service';
import { MAT_PROGRESS_SPINNER_DEFAULT_OPTIONS } from '@angular/material';


@Component({
  selector: 'app-needtrip',
  templateUrl: './needtrip.component.html',
  styleUrls: ['./needtrip.component.css']
})
export class NeedtripComponent {
  public from = new String();
  public to = new String();
  public time = new String();
  public trips =[];
  public rideDetails = new RideDetails();
  public user = new User();
  
  constructor(private  riderService:RiderService,private tripService:TripService,private router:Router, private activatedRoute:ActivatedRoute) { 

    console.log(this.router.getCurrentNavigation().extras.state);
    this.user = this.router.getCurrentNavigation().extras.state as User;

    localStorage.setItem("user", JSON.stringify(this.user));

    this.rideDetails.rider= this.user;
    this.rideDetails.trip = new Trip();
  }

  

  book(){

   this.rideDetails.trip.id
   for(let t of this.trips){
        if(t.id === this.rideDetails.trip.id){
          this.rideDetails.trip=t;
          this.rideDetails.rider=this.user
        }
      }
        this.riderService.confirmRide(this.rideDetails).subscribe(data => {
          this.rideDetails=data;     
          
        });

   }

  

  
  searchtrip(){

    this.tripService.searchTrips(this.from,this.to,this.time)
    .subscribe(data => {
      this.trips=data; 
      this.router.navigateByUrl('/searchtrip', { state:  this.trips });    
      
    });

     
  }

  back(){   
   this.router.navigateByUrl('/dashboard', { state: this.user });  
  }
}
