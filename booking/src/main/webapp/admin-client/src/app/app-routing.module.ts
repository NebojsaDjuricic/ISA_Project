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
import {CreateRoomComponent} from './components/home/hotel-admin/create-room/create-room.component';
import {CreateNewHotelComponent} from './components/home/sys-admin-home/create-new-hotel/create-new-hotel.component';
import {EditRoomComponent} from './components/home/hotel-admin/edit-room/edit-room.component';
import {RoomListComponent} from './components/home/hotel-admin/room-list/room-list.component';
import {EditHotelComponent} from './components/home/hotel-admin/edit-hotel/edit-hotel.component';
import {HotelsListComponent} from './components/home/sys-admin-home/hotels-list/hotels-list.component';
import {EditAdminComponent} from './components/home/sys-admin-home/edit-admin/edit-admin.component';
import {AdminListComponent} from './components/home/sys-admin-home/admin-list/admin-list.component';
import {CreatePriceComponent} from './components/home/hotel-admin/create-room/create-price/create-price.component';
import { EditRentACarServiceComponent } from './components/home/rent-a-car-service-admin/edit-rent-a-car-service/edit-rent-a-car-service.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: HomeComponent },
  { path: 'addRoom', component: CreateRoomComponent },
  { path: 'addRoom/addPrice', component: CreatePriceComponent },
  { path: 'add-hotel', component: CreateNewHotelComponent },
  { path: 'add-rent-a-car-service', component: CreateRentACarServiceComponent },
  { path: 'add-new-admin', component: CreateNewAdminComponent },
  { path: 'add-vehicle', component: CreateVehicleComponent },
  { path: 'add-branch', component: CreateBranchComponent },
  { path: 'hotels', component: HotelsListComponent },
  { path: 'edit-vehicle/:branchID/:vehicleID', component: EditVehicleComponent},
  { path: 'edit-room/:hotelID/:roomID', component: EditRoomComponent},
  { path: 'hotels/edit-hotel/:hotelID', component: EditHotelComponent},
  { path: 'editHotel/:hotelID', component: EditHotelComponent},
  { path: 'admins', component: AdminListComponent},
  { path: 'admins/edit-admin/:adminUsername', component: EditAdminComponent},
  { path: 'myProfile/:adminUsername', component: EditAdminComponent},
  { path: 'edit-rent-a-car', component: EditRentACarServiceComponent}
  // { path: 'myHotel/:adminHotel', component: EditHotelComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
