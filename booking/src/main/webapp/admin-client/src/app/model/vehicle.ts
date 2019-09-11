export class Vehicle {
    name: String;
    brand: String;
    model: String;
    licenceID: String;
    status: VehicleStatus.Value;
    price: number;
    rating: number;
    branchID: String;
    admin: String;
    manufacturingYear: number;
    numberOfSeats: number;
    vehicleType: VehicleTypeEnum.Value;

    constructor() {
        this.status = VehicleStatus.Value.WITHOUT_APPOINTED_BRANCH;
        this.rating = 0;
    }
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
