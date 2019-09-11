import { Address } from '../model/address';
import { Branch } from '../model/branch';
import { VehicleDiscount } from './vehicleDiscount';
import { BranchesAndVehiclesMap } from './branchesAndVehiclesMap';

export class RentACar {
    id: String;
    name: String;
    description: String;
    rating: number;
    address: Address;
    branches: Branch[];
    vehiclesOnDiscount: VehicleDiscount[];
    vehicles: String[];
    branchesAndVehicles: BranchesAndVehiclesMap[];

    constructor() {
        this.id = null;
        this.name = '';
        this.description = '';
        this.rating = null;
        this.address = null;
        this.branches = null;
        this.vehiclesOnDiscount = null;
        this.vehicles = null;
        this.branchesAndVehicles = null;
    }
}
