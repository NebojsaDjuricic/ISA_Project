import { FormGroup } from '@angular/forms';

export class RegistrationValidator {
  static validate(createAdminForm: FormGroup) {
    const password = createAdminForm.controls.password.value;
    const repeatPassword = createAdminForm.controls.passwordRepeat.value;

    if (repeatPassword.length <= 0) {
      return null;
    }

    if (repeatPassword !== password) {
      return {
        doesMatchPassword: true
      };
    }

    return null;

  }
}
