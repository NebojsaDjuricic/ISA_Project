
module AdminRole {
  export enum Value {
    SYSTEM_ADMIN,
    AIRLINE_ADMIN,
    HOTEL_ADMIN,
    RENT_A_CAR_SERVICE_ADMIN
  }
}

export class Administrator {
  username: String;
  password: String;
  // passwordRepeat: String;
  email: String;
  type: AdminRole.Value;
  editingObjectID: String;

  constructor() {
    this.username = '';
    this.password = '';
    // this.passwordRepeat = '';
    this.email = '';
    this.type = null;
    this.editingObjectID = '';
  }

    // ####### added new ##########
  // constructor(public username: string,
  //             public password: string,
  //             public email: string,
  //             public role: AdminRole.Value,
  //             public editingObjectID: string) {}

  // get token() {
  //   if (!this._tokenExpirationDate || new Date() > this._tokenExpirationDate) {
  //     return null;
  //   }
  //   return this._token;
  // }
  // #######################

}

