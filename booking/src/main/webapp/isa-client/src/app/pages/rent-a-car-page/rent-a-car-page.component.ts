import { Component, OnInit } from '@angular/core';
import { RentACar } from '../../model/rent-a-car';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { RentACarService } from '../../services/rent-a-car.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-rent-a-car-page',
  templateUrl: './rent-a-car-page.component.html',
  styleUrls: ['./rent-a-car-page.component.css']
})
export class RentACarPageComponent implements OnInit {

  company: RentACar;

  constructor(
    private rentACarService: RentACarService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit() {
    this.getInfo();
  }

  getInfo() {
    const id = this.route.snapshot.paramMap.get('id');
    this.rentACarService.getRentACar(id).subscribe(
      retVal => {
        this.company = retVal;
      }
    );
  }

}
