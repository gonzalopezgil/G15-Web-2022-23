import { Component,OnInit,Output,EventEmitter, Input, OnChanges } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent {
  loginForm: FormGroup = new FormGroup({});
  @Input() loginError: String = "";
  @Output() loginAction: EventEmitter<{}> = new EventEmitter<{}>();

  constructor(private fb: FormBuilder) {};

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required]
    });
  }

  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

  //Submit del formulario login

  submitLogin(){
    if (this.loginForm.valid) {
      this.loginAction.emit(this.loginForm.value);
    }
  }
}
