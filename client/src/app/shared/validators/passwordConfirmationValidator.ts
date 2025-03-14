import { AbstractControl, ValidationErrors } from "@angular/forms";

export class PasswordConfirmationValidator {
  static passwordMatchValidator(
    control: AbstractControl,
  ): ValidationErrors | null {
    const password = control.get("password");
    const confirmPassword = control.get("confirmPassword");

    if (
      !password ||
      !confirmPassword ||
      !password.value ||
      !confirmPassword.value
    ) {
      return null;
    }

    return password.value === confirmPassword.value
      ? null
      : { passwordsNotMatch: true };
  }
}
