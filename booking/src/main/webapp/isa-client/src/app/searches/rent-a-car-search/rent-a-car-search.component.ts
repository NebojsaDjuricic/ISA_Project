import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleSearchDTO } from 'src/app/model/vehicleSearchDTO';
import { VehicleService } from '../../services/vehicle.service';
import { VehicleType } from '../../model/vehicleType';
import { Observable } from 'rxjs';
import { Vehicle } from 'src/app/model/vehicle';

@Component({
  selector: 'app-rent-a-car-search',
  templateUrl: './rent-a-car-search.component.html',
  styleUrls: ['./rent-a-car-search.component.css']
})
export class RentACarSearchComponent implements OnInit {

  searchForm: FormGroup;
  vehicleSearch: VehicleSearchDTO;

  @Input() rentACarServiceID: String;

  searchResult: Vehicle[];

  @Output() queryResultEvent = new EventEmitter<Object>();

  vehicleTypes: VehicleType[] = [
    { value: 'HATCHBACK', name: 'Hatchback'},
    { value: 'SEDAN', name: 'Sedan' },
    { value: 'MPV', name: 'MPV'},
    { value: 'SUV', name: 'SUV'},
    { value: 'CROSSOVER', name: 'Crossover'},
    { value: 'COUPE', name: 'Coupe'},
    { value: 'CONVERTIBLE', name: 'Convertible'}
  ];

  constructor(private formBuilder: FormBuilder, private vehicleService: VehicleService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      startPlace: ['', Validators.required],
      endPlace: ['', Validators.required],
      type: ['', Validators.required],
      passengers: ['', Validators.required],
      minPrice: [''],
      maxPrice: [''],
      rentACarServiceID: [this.rentACarServiceID , Validators.required]
    });

    this.vehicleSearch = new VehicleSearchDTO();
    

  }

  onSubmit() {
    console.log('Submit search');

    this.vehicleSearch.endDate = this.searchForm.controls.endDate.value;
    this.vehicleSearch.endPlace = this.searchForm.controls.endPlace.value;
    this.vehicleSearch.startDate = this.searchForm.controls.startDate.value;
    this.vehicleSearch.startPlace = this.searchForm.controls.startPlace.value;
    this.vehicleSearch.type = this.searchForm.controls.type.value;
    this.vehicleSearch.passengers = this.searchForm.controls.passengers.value;
    this.vehicleSearch.minPrice = this.searchForm.controls.minPrice.value;
    this.vehicleSearch.maxPrice = this.searchForm.controls.maxPrice.value;
    this.vehicleSearch.rentACarServiceID = this.searchForm.controls.rentACarServiceID.value;

    this.vehicleService.makeQuery(this.vehicleSearch).subscribe(
      res => {
        console.log("Search result: " + res);
        this.queryResultEvent.emit(this.searchResult);
      }
    );
  }

}
