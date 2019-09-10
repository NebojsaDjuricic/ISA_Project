import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomePageForRegisteredUserComponent } from './home/home-page-for-registered-user/home-page-for-registered-user.component';
import { ShowAllRentACarServicesComponent } from './listing/show-all-rent-a-car-services/show-all-rent-a-car-services.component';
import { RentACarSearchComponent } from './searches/rent-a-car-search/rent-a-car-search.component';
import { RentACarPageComponent } from './pages/rent-a-car-page/rent-a-car-page.component';
import { HotelsComponent } from './pages/hotels-page/hotels/hotels.component';
import { FlightsComponent } from './pages/flights/flights.component';
import { ShowAllHotelsComponent } from './listing/show-all-hotels/show-all-hotels.component';
import { ShowAllFlightsComponent } from './listing/show-all-flights/show-all-flights.component';
import { HotelSearchComponent } from './searches/hotel-search/hotel-search.component';
import { HotelItemComponent } from './pages/hotels-page/hotels/hotel-item/hotel-item.component';
import { HotelDetailComponent } from './pages/hotels-page/hotel-detail/hotel-detail.component';
import { RoomsComponent } from './pages/rooms/rooms.component';
import { FindRentACarServiceComponent } from './searches/find-rent-a-car-service/find-rent-a-car-service.component';
import { FindHotelsComponent } from './searches/find-hotels/find-hotels.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    LoginComponent,
    RegisterComponent,
    HomePageForRegisteredUserComponent,
    ShowAllRentACarServicesComponent,
    RentACarSearchComponent,
    RentACarPageComponent,
    HotelsComponent,
    FlightsComponent,
    ShowAllHotelsComponent,
    ShowAllFlightsComponent,
    HotelSearchComponent,
    HotelItemComponent,
    HotelDetailComponent,
    RoomsComponent,
    FindRentACarServiceComponent,
    FindHotelsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
