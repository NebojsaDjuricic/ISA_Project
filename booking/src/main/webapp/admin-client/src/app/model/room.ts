import {AdditionalService} from './additionalService';
import {Price} from './price';

export class Room {
  id: String;
  status: RoomStatus.Value;
  type: RoomType.Value;
  capacity: number;
  floor: number;
  rating: number;
  additionalServices: AdditionalService[];
  prices: Price[];

  constructor() {
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
