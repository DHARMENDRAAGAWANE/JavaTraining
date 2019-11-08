import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { map, filter} from 'rxjs/operators';
import {User} from '../model/user'
import { Vehicle } from '../model/vehicle'
import {VehicleService} from '../service/vehicle.service'
@Component({
  selector: 'app-vechile',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  public vehicle = new Vehicle(); 
  public user = new User();
  constructor(private vehicleService:VehicleService,private router:Router, private activatedRoute:ActivatedRoute) { 

    console.log(this.router.getCurrentNavigation().extras.state);
    this.user = this.router.getCurrentNavigation().extras.state as User;
    if(!this.router.getCurrentNavigation().extras.state || !this.user || !this.user.username){
      this.router.navigateByUrl('/login');  
    }
  }

  ngOnInit() {
  }


  registervehicle(){
    this.vehicle.owner=this.user;
    this.vehicleService.saveVehicals(this.vehicle).subscribe(data => {
      this.vehicle=data; 
       
      this.router.navigateByUrl('/drivertrip', { state: this.user});  
      }   
               
    );
  }

  back(){
    this.router.navigateByUrl('/dashboard', { state: this.user });  
  }
}
