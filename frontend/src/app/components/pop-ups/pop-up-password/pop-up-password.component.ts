import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-pop-up-password',
  templateUrl: './pop-up-password.component.html',
  styleUrls: ['./pop-up-password.component.scss']
})
export class PopUpPasswordComponent {

  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private UserService: UsersService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      oldpassword: ['',Validators.required],
      password: ['',Validators.compose([Validators.required,Validators.minLength(8)])],
      confirmpassword: ['',Validators.compose([Validators.required,Validators.minLength(8)])]
    });
  }
  
  get password() {
    return this.form.get('password');
  }

  get oldpassword() {
    return this.form.get('oldpassword');
  }

  get confirmpassword() {
    return this.form.get('confirmpassword');
  }

  onSubmit() {
    if(this.form.valid) {
      this.UserService.changePassword(this.form.value.password, this.form.value.oldpassword, this.form.value.confirmpassword);
    }
  }
}
