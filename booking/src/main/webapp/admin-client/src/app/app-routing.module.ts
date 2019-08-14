import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
// tslint:disable-next-line:max-line-length
import { CreateRentACarServiceComponent } from './components/home/sys-admin-home/create-rent-a-car-service/create-rent-a-car-service.component';
import { CreateNewAdminComponent } from './components/home/sys-admin-home/create-new-admin/create-new-admin.component';
import { CreateVehicleComponent } from './components/home/rent-a-car-service-admin/create-vehicle/create-vehicle.component';
import { CreateBranchComponent } from './components/home/rent-a-car-service-admin/create-branch/create-branch.component';
import { EditVehicleComponent } from './components/home/rent-a-car-service-admin/edit-vehicle/edit-vehicle.component';
import {AuthComponent} from './components/auth/auth.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  // { path: 'login', component: AuthComponent },
  { path: '', component: HomeComponent },
  { path: 'add-rent-a-car-service', component: CreateRentACarServiceComponent },
  { path: 'add-new-admin', component: CreateNewAdminComponent },
  { path: 'add-vehicle', component: CreateVehicleComponent },
  { path: 'add-branch', component: CreateBranchComponent },
  { path: 'edit-vehicle/:branchID/:vehicleID', component: EditVehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
