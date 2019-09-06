export class VehicleType {
    name: String;
    value: String;
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