import { Address } from '../model/address';
import { Branch } from '../model/branch';

export class RentACar {
    id: String;
    name: String;
    description: String;
    rating: number;
    address: Address;
    branches: Branch[];

    constructor() {
        this.id = null;
        this.name = '';
        this.description = '';
        this.rating = null;
        this.address = null;
        this.branches = null;
    }
}
