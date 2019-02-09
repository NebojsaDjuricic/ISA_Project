import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { SysAdminHomeComponent } from './components/home/sys-admin-home/sys-admin-home.component';
import { RentACarServiceAdminComponent } from './components/home/rent-a-car-service-admin/rent-a-car-service-admin.component';
import { CreateRentACarServiceComponent } from './components/home/sys-admin-home/create-rent-a-car-service/create-rent-a-car-service.component';
import { CreateNewAdminComponent } from './components/home/sys-admin-home/create-new-admin/create-new-admin.component';
import { CreateVehicleComponent } from './components/home/rent-a-car-service-admin/create-vehicle/create-vehicle.component';
import { CreateBranchComponent } from './components/home/rent-a-car-service-admin/create-branch/create-branch.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    HomeComponent,
    SysAdminHomeComponent,
    RentACarServiceAdminComponent,
    CreateRentACarServiceComponent,
    CreateNewAdminComponent,
    CreateVehicleComponent,
    CreateBranchComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
