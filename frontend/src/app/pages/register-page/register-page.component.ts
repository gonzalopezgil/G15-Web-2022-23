import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TutorsService } from 'src/app/services/tutors.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent {
  pending:boolean = false;

  constructor(private router:Router, private tutorService: TutorsService) { }

  ngOnInit(): void {
    let token = sessionStorage.getItem('token');
    if (token) {
      this.router.navigate(['/home']);
    }
  }

  registerUser(value: any): void {
    let tutor = {
      username: value.username,
      password: value.password,
      nif: value.nif,
      email: value.email,
      name: value.name,
      lastname: value.surname,
      admission_date: new Date(),
      active: false
    }

    let response = this.tutorService.registerTutor(tutor);
    this.pending = true;
    response.subscribe(
      (response) => {
        if(response.status == 200) {
          this.router.navigate(['/login']);
        }else {
          this.pending = false;
        }
      }
    );
    this.pending = false;
  }
}
