import {Component, Input, OnChanges, OnInit} from '@angular/core';
// @ts-ignore
import {FormArray, FormBuilder, FormControl, FormControlName, FormGroup, Validators} from '@angular/forms';
import {RoomDTO} from '../../../../model/roomDTO';
import {Hotel} from '../../../../model/hotel';
import {RoomService} from '../../../../services/room.service';
import {HotelService} from '../../../../services/hotel.service';
import {AuthServiceService} from '../../../../services/auth-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {timeout} from 'rxjs/operators';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit, OnChanges {

  createRoomForm: FormGroup;
  room: RoomDTO;
  hotels: Hotel;
  errorMessage = 'This field is required!';
  addPriceClicked = false;

  mymodel: any;
  // @Input() roomType: FormControlName;
  // submitted = false;

  constructor(private formBuilder: FormBuilder,
              private roomService: RoomService,
              private hotelService: HotelService,
              private auth: AuthServiceService,
              private router: Router,
              private route: ActivatedRoute
  ) { }

  ngOnChanges(changes: import('@angular/core').SimpleChanges): void {

  }

  ngOnInit() {
    this.createRoomForm = this.formBuilder.group(
      {
        hotel: ['', Validators.required],
        roomType: new FormControl('', [Validators.required]),
        roomStatus: new FormControl('', [Validators.required]),
        capacity: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
        floor: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),

        // Price[] dodati

      }
    );

    const adminID = this.auth.getAdminUsername();

    this.hotelService.getAdminHotel(adminID)
      .subscribe(
        res => {
          this.hotels = res;
        }
      );

    // this.hotelService.getHotels()
    //   .subscribe(
    //     res => {
    //       this.hotels = res;
    //     }
    //   );

    this.room = new RoomDTO();
  }

  private initForm() {

  }

  generateRandomInteger(min, max) {
    return Math.floor(min + Math.random() * (max + 1 - min));
  }

  onSubmit() {
    this.room.status = this.createRoomForm.controls.roomStatus.value;
    this.room.type = this.createRoomForm.controls.roomType.value;
    this.room.hotelID = this.createRoomForm.controls.hotel.value;
    this.room.floor = this.createRoomForm.controls.floor.value;
    this.room.capacity = this.createRoomForm.controls.capacity.value;
    this.room.id = this.createRoomForm.controls.hotel.value + '.' +
                    this.createRoomForm.controls.floor.value +
                    this.createRoomForm.controls.capacity.value +
                    this.generateRandomInteger(10000, 99999);

    // let tipSobe;
    //
    // if (this.room.type === RoomType.Value.SINGLE) {
    //   tipSobe = 1;
    // } else if (this.room.type === RoomType.Value.DOUBLE) {
    //   tipSobe = 2;
    // } else if (this.room.type === RoomType.Value.TRIPLE) {
    //   tipSobe = 3;
    // } else if (this.room.type === RoomType.Value.QUAD) {
    //   tipSobe = 4;
    // } else {
    //   tipSobe = 0;
    // }
    //
    // this.room.capacity = tipSobe;

    this.roomService.addRoom(this.room)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  getControls() {
    return (this.createRoomForm.get('prices') as FormArray).controls;
  }

  onChange(newValue) {

    this.mymodel = newValue;
    console.log(this.mymodel);

    // let tipSobe;
    if (this.createRoomForm.controls.roomType.value === 0) {
      this.mymodel = 1;
    } else if (this.createRoomForm.controls.roomType.value === 1) {
      this.mymodel = 2;
    } else if (this.createRoomForm.controls.roomType.value === 2) {
      this.mymodel = 3;
    } else if (this.createRoomForm.controls.roomType.value === 3) {
      this.mymodel = 4;
    } else {
      this.mymodel = 0;
    }

    console.log('After change: ' + this.mymodel);

    // this.room.capacity = tipSobe;

  }

  onChanges(): void {
    this.createRoomForm.get('roomType').valueChanges.subscribe(val => {
      // this.formattedMessage = `My name is ${val}.`;
      console.log('val: ' + val);
      if (val === RoomType.Value.SINGLE) {
        this.mymodel = 1;
      } else if (val === RoomType.Value.DOUBLE) {
        this.mymodel = 2;
      } else if (val === RoomType.Value.TRIPLE) {
        this.mymodel = 3;
      } else if (val === RoomType.Value.QUAD) {
        this.mymodel = 4;
      } else {
        this.mymodel = 0;
      }
    });
  }

  onAddPrice() {
    // this.addPriceClicked = true;
    // console.log(this.addPriceClicked);
    // this.addPriceClicked = false;
    this.router.navigate(['/addRoom/addPrice']);
  }

  onDelete(id: String) {

  }
}

module RoomStatus {
  export enum Value {
    AVAILABLE,
    RESERVED,
    OCCUPIED
  }
}

module RoomType {
  export enum Value {
    SINGLE,
    DOUBLE,
    TRIPLE,
    QUAD
  }
}
