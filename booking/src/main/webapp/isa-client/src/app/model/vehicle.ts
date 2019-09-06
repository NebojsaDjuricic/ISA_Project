import { } from '../model/vehicleType'

export class Vehicle {
    brand: String;
    model: String;
    licenceID: String;
    status: VehicleStatus.Value;
    price: number;
    rating: number;
    name: String;
    manufacturingYear: number;
    numberOfSeats: number;
    vehicleType: VehicleTypeEnum.Value;
}

module VehicleStatus {
    export enum Value {
        IN_SERVICE,
        OUT_OF_SERVICE,
        WITHOUT_APPOINTED_BRANCH
    }
}

module VehicleTypeEnum {
    export enum Value {
        HATCHBACK, 
        SEDAN, 
        MPV, 
        SUV, 
        CROSSOVER, 
        COUPE, 
        CONVERTIBLE
    }
}
