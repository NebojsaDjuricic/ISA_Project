import {Price} from './price';

export class Room {
  id: String;
  status: RoomStatus.Value;
  type: RoomType.Value;
  capacity: number;
  pricePerNight: number;
  prices: Price[];
  floor: number;
  rating: number;
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

