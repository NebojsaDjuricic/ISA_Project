export class Room {
  id: String;
  status: RoomStatus.Value;
  type: RoomType.Value;
  capacity: number;
  pricePerNight: number;
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

