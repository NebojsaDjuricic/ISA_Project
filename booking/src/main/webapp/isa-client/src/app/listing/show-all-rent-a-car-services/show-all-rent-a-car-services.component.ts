import { Component, OnInit } from '@angular/core';
import { RentACarService } from '../../services/rent-a-car.service';
import { RentACar } from '../../model/rent-a-car';
import { Observable } from 'rxjs';
import { RentACarSearchResultDTO } from 'src/app/model/rent-a-carSearchResultDTO';

@Component({
  selector: 'app-show-all-rent-a-car-services',
  templateUrl: './show-all-rent-a-car-services.component.html',
  styleUrls: ['./show-all-rent-a-car-services.component.css']
})
export class ShowAllRentACarServicesComponent implements OnInit {

  data: Observable<RentACar[]>;
  rentACarSearchResult: RentACarSearchResultDTO;
  searchedRentACarServices: RentACar[];

  constructor(private rentACarService: RentACarService) { }

  ngOnInit() {
    this.getAllRentACarServices();
  }

  getAllRentACarServices() {
    this.data = this.rentACarService.getAll();
  }

  fetchQueryResults($event) {
    this.rentACarSearchResult = $event;
    this.searchedRentACarServices = this.rentACarSearchResult.queryResult;
  }

}
