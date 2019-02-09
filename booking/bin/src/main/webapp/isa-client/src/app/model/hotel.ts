import {Address} from './address';
import {Room} from './room';
import {AdditionalService} from './additionalService';


export class Hotel {
  id: String;
  name: String;
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
}
