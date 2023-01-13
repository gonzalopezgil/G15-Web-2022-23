import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent {
  registerForm: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6)
    ]),
    passwordConfirm: new FormControl('', [
      Validators.required,
      //this.passwordValidator.validate(this.registerForm.get('password'))
    ]),
    nif: new FormControl('', [Validators.required, Validators.pattern('[0-9]{8}-[A-Z]{1}')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    name: new FormControl('', [Validators.pattern('[a-zA-Z ]*'), Validators.required]),
    surname: new FormControl('', [Validators.pattern('[a-zA-Z ]*'), Validators.required]),
  });
  @Output() registerAction: EventEmitter<{}> = new EventEmitter<{}>();



  constructor() { }

  ngOnInit(): void {
  }

  ngOnSubmit() {
    this.registerAction.emit(this.registerForm.value);
  }
}
