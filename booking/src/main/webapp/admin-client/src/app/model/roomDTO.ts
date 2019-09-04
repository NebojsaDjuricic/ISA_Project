import {Price} from './price';

export class RoomDTO {
  id: String;
  status: RoomStatus.Value;
  type: RoomType.Value;
  capacity: number;
  floor: number;
  prices: Price[];
  hotelID: String;
  rating: number;

  constructor() {
    this.status = RoomStatus.Value.AVAILABLE;
    this.rating = 0.0;
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
