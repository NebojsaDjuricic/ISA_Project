import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RentACarSearchDTO } from '../../model/rent-a-carSearchDTO';
import { RentACarSearchResultDTO } from 'src/app/model/rent-a-carSearchResultDTO';
import { RentACarService } from 'src/app/services/rent-a-car.service';

@Component({
  selector: 'app-find-rent-a-car-service',
  templateUrl: './find-rent-a-car-service.component.html',
  styleUrls: ['./find-rent-a-car-service.component.css']
})
export class FindRentACarServiceComponent implements OnInit {

  searchForm: FormGroup;
  queryInput: RentACarSearchDTO;
  queryResult: RentACarSearchResultDTO;
  
  @Output() queryResultEvent = new EventEmitter<Object>();

  constructor(private formBuilder: FormBuilder, private rentACarServiceService: RentACarService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      name: ['', Validators.required]      
    });

    this.queryInput = new RentACarSearchDTO();
  }

  onSubmit() {
    this.queryInput.name = this.searchForm.controls.name.value;

    this.rentACarServiceService.search(this.queryInput).subscribe(
      res => {
        this.queryResult = res;

        this.queryResultEvent.emit(this.queryResult);
      }
    );

  }

}
