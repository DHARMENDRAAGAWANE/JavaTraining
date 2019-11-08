import { Component, OnInit } from '@angular/core';
import {UserService} from '../service/user.service'
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
//import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { map, filter} from 'rxjs/operators';
import {User} from '../model/user'
@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrls: ['./userregister.component.css']
})
export class UserregisterComponent implements OnInit {
  //registerForm: FormGroup;
  submitted = false;
  public user = new User();

  constructor(private _service:UserService,private router : Router){
     console.log(this.router.getCurrentNavigation().extras.state);
    this.user = this.router.getCurrentNavigation().extras.state as User;
    if(!this.router.getCurrentNavigation().extras.state || !this.user || !this.user.username){
      this.router.navigateByUrl('/login');  
    }
  }

  ngOnInit() {

    /*this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.minLength(6)]],
      
      acceptTerms: [false, Validators.requiredTrue]
  }, {
     // validator: MustMatch('password', 'confirmPassword')
  });*/
  }

  register(){


    
    this._service.register(this.user)
    .subscribe(data => {
      this.user=data;     
      console.log(this.user);
      
        this.router.navigateByUrl('/dashboard', { state: this.user });  
      
      
    });
  //  this.submitted = true;

    // stop here if form is invalid
    /*if (this.registerForm.invalid) {
        return;
    }*/

    // display form values on success
    //alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
  }

  onReset() {
    this.submitted = false;
    //this.registerForm.reset();
}

}
