import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleSearchDTO } from 'src/app/model/vehicleSearchDTO';
import { VehicleService } from '../../services/vehicle.service';

@Component({
  selector: 'app-rent-a-car-search',
  templateUrl: './rent-a-car-search.component.html',
  styleUrls: ['./rent-a-car-search.component.css']
})
export class RentACarSearchComponent implements OnInit {

  searchForm: FormGroup;
  vehicleSearch: VehicleSearchDTO;

  constructor(private formBuilder: FormBuilder, private vehicleService: VehicleService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      startPlace: ['', Validators.required],
      endPlace: ['', Validators.required],
      type: ['', Validators.required],
      passengers: ['', Validators.required]
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
    this.vehicleSearch.passengers = this.searchForm.controls.passangers.value;
    this.vehicleSearch.minPrice 

    console.log(this.vehicleSearch);

    this.vehicleService.makeQuery(this.vehicleSearch).subscribe(
      res => {
        console.log(res);
      }
    );
  }

}
