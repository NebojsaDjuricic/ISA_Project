export class Vehicle {
    brand: String;
    model: String;
    licenceID: String;
    status: VehicleStatus.Value;
    price: number;
    rating: number;
}

module VehicleStatus {
    export enum Value {
        IN_SERVICE,
        OUT_OF_SERVICE,
        WITHOUT_APPOINTED_BRANCH
    }
}
