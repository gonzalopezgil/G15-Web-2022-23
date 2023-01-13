import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { TutorsService } from 'src/app/services/tutors.service';
import { PopUpTutorregisterComponent } from '../../pop-ups/pop-up-tutorregister/pop-up-tutorregister.component';

@Component({
  selector: 'app-tutorregisterform',
  templateUrl: './tutorregisterform.component.html',
  styleUrls: ['./tutorregisterform.component.scss']
})
export class TutorregisterformComponent {
  
  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder,private TutorsService: TutorsService,private router: Router,private dialog: MatDialog) { }

  ngOnInit(): void {
    let date = new Date();
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['',Validators.compose([ Validators.required, Validators.minLength(8)])],
      confirmpassword: ['',Validators.compose([ Validators.required, Validators.minLength(8)])],
      email: ['',Validators.compose([ Validators.required, Validators.email])],
      name: ['',Validators.required],
      lastname: ['',Validators.required],
      nif: ['',Validators.required],
      admissiondate: [date,Validators.required]
    });
  }

  get username() {
    return this.form.get('username');
  }

  get password() {
    return this.form.get('password');
  }

  get confirmpassword() {
    return this.form.get('confirmpassword');
  }

  get email() {
    return this.form.get('email');
  }

  get name() {
    return this.form.get('name');
  }

  get lastname() {
    return this.form.get('lastname');
  }

  get nif() {
    return this.form.get('nif');
  }

  get admissiondate() {
    return this.form.get('admissiondate');
  }
  
  clearForm() {
    this.form.reset();
  }

  onSubmit() {
    if(this.form.valid) {
      let texto = "";
      let aux = false;
      if(this.form.value.password != this.form.value.confirmpassword) {
        texto = "Las contraseñas no coinciden";
      }else{
        aux = this.TutorsService.createTutor(this.form);
        if(aux){
          texto="El tutor se ha registrado correctamente";
        }else{
          texto="Error al registrar el tutor";
        }
      }
      this.dialog.open(PopUpTutorregisterComponent, { data: { boolean: aux ,txt: texto}});
    }
  }
}
