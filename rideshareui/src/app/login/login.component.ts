import { Component, OnInit } from '@angular/core';
import { User}  from '../model/user';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {UserService} from '../service/user.service'

import { HttpClient,  HttpHeaders  } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  

  public title="RideShare" 
    public user = new User();
    public errorMsg = '';

    constructor(public dialog: MatDialog,  private _service:UserService,private router : Router) {}
 
    
    login() {

      this._service.validUserId(this.user)
    .subscribe(data => {
      this.user=data;     
      console.log(this.user);
      if(!this.user.email){
      this.router.navigateByUrl('/userregister', { state: this.user });  
      }else{
        this.router.navigateByUrl('/dashboard', { state: this.user });  
      }
      
    });
      //this._service.validUserId(this.user);
        
    }
  
   register() {
   // this._service.register();
  }


}
