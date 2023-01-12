import { TutorsService } from 'src/app/services/tutors.service';
import { Component,Inject,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-pop-up-password',
  templateUrl: './pop-up-password.component.html',
  styleUrls: ['./pop-up-password.component.scss']
})
export class PopUpPasswordComponent implements OnInit {

  form: FormGroup = new FormGroup({});

  constructor(@Inject(MAT_DIALOG_DATA) public data: boolean,
              private fb: FormBuilder,
              private UserService: UsersService,
              private TutorService: TutorsService,
              private dialogRef: MatDialogRef<any>) { }

  ngOnInit(): void {
    this.dialogRef.updateSize('500px');
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
      if(this.data){
        this.UserService.changePassword(this.form.value.password, this.form.value.oldpassword, this.form.value.confirmpassword);
      }
    }
  }
}
