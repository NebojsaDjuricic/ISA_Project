import { GPSCoordinates } from './GPSCoordinates';

export class Address {
    streetName: String;
    buildingNumber: String;
    city: String;
    country: String;
    coordinatePosition: GPSCoordinates;

    constructor() {
    }
}
