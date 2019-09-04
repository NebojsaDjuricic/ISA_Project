import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Room} from '../../../../model/room';
import {RoomDTO} from '../../../../model/roomDTO';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from '../../../../services/room.service';
import {AuthServiceService} from '../../../../services/auth-service.service';

@Component({
  selector: 'app-edit-room',
  templateUrl: './edit-room.component.html',
  styleUrls: ['./edit-room.component.css']
})
export class EditRoomComponent implements OnInit {

  editRoomForm: FormGroup;
  room: Room;
  editedRoom: RoomDTO;
  hotelID: String;
  roomID: String;
  submitted = false;
  errorMessage = 'Invalid value!';
  room_id: String;

  constructor(private formBuilder: FormBuilder,
              private roomService: RoomService,
              private auth: AuthServiceService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.getRoom(this.route.snapshot.params['roomID']);
    this.editRoomForm = this.formBuilder.group(
      {
        roomType: new FormControl('', [Validators.required]),
        roomStatus: new FormControl('', [Validators.required]),
        capacity: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),
        floor: new FormControl(null, [Validators.required, Validators.pattern(/^[1-9]\d*$/)]),

      }
    );

    this.editedRoom = new RoomDTO();

    this.route.params.subscribe(
      params => {
        this.hotelID = params['hotelID'];
        this.roomID = params['roomID'];
      }
    );

    this.room = new RoomDTO();
    this.roomService.getRoom(this.roomID)
      .subscribe(
        res => {
          this.room = res;
          // console.log('this.room ' + JSON.stringify(this.room));
        }
      );

  }

  getRoom(id) {
    this.roomService.getRoom(id).subscribe(data => {
      this.room_id = data.id;
      this.editRoomForm.setValue({
        roomType: data.type,
        roomStatus: data.status,
        capacity: data.capacity,
        floor: data.floor,
        // rating: data.rating
      });
    });
  }

  onSubmit() {
    this.submitted = true;

    this.editedRoom.id = this.roomID;
    this.editedRoom.hotelID = this.hotelID;
    this.editedRoom.type = this.editRoomForm.controls.roomType.value;
    this.editedRoom.status = this.editRoomForm.controls.roomStatus.value;
    this.editedRoom.floor = this.editRoomForm.controls.floor.value;
    this.editedRoom.capacity = this.editRoomForm.controls.capacity.value;
    // this.editedRoom.admin = this.auth.getAdminUsername();

    this.roomService.editRoom(this.editedRoom)
      .subscribe(
        res => {
          console.log(res);
        }
      );

    this.router.navigate(['/']);
  }

  onCancel() {
    this.router.navigate(['/']);
  }
}
