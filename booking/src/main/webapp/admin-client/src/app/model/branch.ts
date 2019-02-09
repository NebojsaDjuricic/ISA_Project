import { Address } from '../model/address';
import { Vehicle } from '../model/vehicle';

export class Branch {
    id: String;
    name: String;
    address: Address;
    phoneNumber: String;
    contactEmail: String;
    vehicles: Vehicle[];

    constructor() {

    }
}
