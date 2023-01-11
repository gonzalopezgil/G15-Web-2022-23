import { Directive } from '@angular/core';
import {AbstractControl, NG_VALIDATORS, Validator, ValidatorFn} from '@angular/forms';

@Directive({
  selector: '[appPasswordsMatchValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: PasswordsMatchValidator, multi: true}]
})


export class PasswordsMatchValidator implements Validator {

    matchPassword(): ValidatorFn {
      return (control: AbstractControl): { [key: string]: any } | null =>
        control.value.password !== control.value.confirmPassword ? { 'passwordsMatch': true } : null;
    }

    validate(control: AbstractControl): { [key: string]: any } | null {
      return this.matchPassword()(control);
    }

}
