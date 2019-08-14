import {Address} from './address';
import {Room} from './room';
import {AdditionalService} from './additionalService';

export class Hotel {

  id: string;
  name: string;
  address: Address;
  phoneNumber: string;
  contactEmail: string;
  description: string;
  website: string;
  rating: number;
  numberOfFloors: number;
  stars: number;
  rooms: Room[];
  additionalServices: AdditionalService[];
  // slike i ocene dodati

  constructor(id: string,
              name: string,
              address: Address,
              num: string,
              email: string,
              desc: string,
              website: string,
              rating: number,
              floors: number,
              stars: number,
              rooms: Room[],
              addServ: AdditionalService[]
  ) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phoneNumber = num;
    this.contactEmail = email;
    this.description = desc;
    this.website = website;
    this.rating = rating;
    this.numberOfFloors = floors;
    this.stars = stars;
    this.rooms = rooms;
    this.additionalServices = addServ;
  }
}
