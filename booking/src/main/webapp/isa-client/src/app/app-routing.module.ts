import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ShowAllRentACarServicesComponent } from './listing/show-all-rent-a-car-services/show-all-rent-a-car-services.component';
import { RentACarPageComponent } from './pages/rent-a-car-page/rent-a-car-page.component';
import { ShowAllHotelsComponent } from './listing/show-all-hotels/show-all-hotels.component';
import { HotelsComponent } from './pages/hotels-page/hotels/hotels.component';
import { ShowAllFlightsComponent } from './listing/show-all-flights/show-all-flights.component';
import { FlightsComponent } from './pages/flights/flights.component';
import {RoomsComponent} from './pages/rooms/rooms.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'rent-a-car-services', component: ShowAllRentACarServicesComponent },
  { path: 'rent-a-car/:id', component: RentACarPageComponent },
  { path: 'hotels', component: ShowAllHotelsComponent },
  { path: 'hotels/:id', component: HotelsComponent },
  { path: 'hotels/:id/:roomId', component: RoomsComponent },
  { path: 'flights', component: ShowAllFlightsComponent },
  { path: 'flights/:id', component: FlightsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
