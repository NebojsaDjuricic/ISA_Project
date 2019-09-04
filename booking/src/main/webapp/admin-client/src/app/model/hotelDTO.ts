import {Address} from './address';
import {Room} from './room';
import {AdditionalService} from './additionalService';

export class HotelDTO {
  id: String;
  name: String;
  admin: String;
  address: Address;
  phoneNumber: String;
  contactEmail: String;
  description: String;
  website: String;
  rating: number;
  numberOfFloors: number;
  stars: number;
  rooms: Room[];
  additionalServices: AdditionalService[];

  constructor() {
  }
}
