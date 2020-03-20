import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import {User} from '../model/user';
import {RideDetails} from '../model/rideDetails';
import {RiderService} from '../service/rider.service';
import {Trip} from '../model/trip';
import {TripService} from '../service/trip.service';
import { MAT_PROGRESS_SPINNER_DEFAULT_OPTIONS } from '@angular/material';

@Component({
  selector: 'app-tripsearch',
  templateUrl: './tripsearch.component.html',
  styleUrls: ['./tripsearch.component.css']
})
export class TripsearchComponent{


  public message = "Carpoolers available near you"
  public from = new String();
  public to = new String();
  public time = new String();
  public trips =[];
  public rideDetails = new RideDetails();
  public user = new User();
  show: boolean = false;
  constructor(private  riderService:RiderService,private tripService:TripService,private router:Router, private activatedRoute:ActivatedRoute) { 

    console.log( this.router.getCurrentNavigation().extras.state);
    if(this.router.getCurrentNavigation().extras.state){
    this.trips= this.router.getCurrentNavigation().extras.state.map(item => item as Trip)
    }
    if(this.trips! || this.trips.length >0){
      this.show = true;
    }else{
      this.show = false;
      this.message='No Ride  for that time , Please look for alternative';
    }

this.user = JSON.parse(localStorage.getItem("user"));
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
           this.trips=[];
           this.message="Ride Confirmed"
         });
 
    }

  onSelectionChange(entry) {
    //this.selectedEntry = entry;
}


back(){   
  this.router.navigateByUrl('/dashboard', { state: this.user });  
 }

  
}
