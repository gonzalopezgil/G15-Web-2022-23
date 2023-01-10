import { Component,OnInit,Output,EventEmitter } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit{
  loginForm: FormGroup = new FormGroup({});
  @Output() loginAction: EventEmitter<{}> = new EventEmitter<{}>();

  constructor(private fb: FormBuilder, private authService: AuthService) {};

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
      //TODO: Llamar al servicio de login
      this.loginAction.emit(this.loginForm.value);
      this.loginForm.reset();
    }
  }
}
