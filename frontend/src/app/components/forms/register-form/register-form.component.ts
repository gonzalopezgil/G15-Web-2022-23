import { Component, EventEmitter, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent {
  registerForm: FormGroup = new FormGroup({});
  @Output() registerAction: EventEmitter<{}> = new EventEmitter<{}>();

  constructor() { }

  ngOnInit(): void {
  }

  ngOnSubmit() {
    if (this.registerForm.valid) {
      this.registerAction.emit(this.registerForm.value);
    }
  }
}
