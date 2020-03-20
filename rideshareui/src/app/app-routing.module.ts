import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent }   from './login/login.component';
import { DashboardComponent} from './dashboard/dashboard.component';
import  { VehicleComponent } from './vehicle/vehicle.component';
import { UserregisterComponent } from './userregister/userregister.component';
import { DrivertripComponent} from './drivertrip/drivertrip.component';
import { NeedtripComponent} from './needtrip/needtrip.component';
import { TripsearchComponent} from './tripsearch/tripsearch.component';
import { TripcreateconfirmComponent} from './tripcreateconfirm/tripcreateconfirm.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'vehicle', component: VehicleComponent },
  { path: 'userregister',component: UserregisterComponent},
  { path: 'drivertrip', component: DrivertripComponent },
  { path: 'needtrip', component: NeedtripComponent},
  { path: 'searchtrip', component: TripsearchComponent},
  { path: 'tripcreateconfirm' , component: TripcreateconfirmComponent}
  
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
