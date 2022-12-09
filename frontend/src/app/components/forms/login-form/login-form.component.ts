import { Component,OnInit,Output,EventEmitter } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent {
  loginForm: FormGroup = new FormGroup({});
  @Output() loginAction: EventEmitter<{}> = new EventEmitter<{}>();

  constructor(private fb: FormBuilder, private authService: AuthService) {};

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['',Validators.compose([Validators.required, Validators.email])],
      password: ['',Validators.required]
    });
  }

  get email() { 
    return this.loginForm.get('email'); 
  }

  get password() { 
    return this.loginForm.get('password'); 
  }

  //Submit del formulario login

  submitLogin(){
    if (this.loginForm.valid) {
      //console.table(this.loginForm.value);
      //TODO: Llamar al servicio de login
      this.loginAction.emit(this.loginForm.value);
      //this.loginForm.reset();
    }
  }
}
