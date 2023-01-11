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
  //   let { username, password, nif, email, name, surname } = value;
  //   let tutor = {username, password, nif, email, name, surname};
  //   let response = this.tutorService.registerTutor(tutor);
  //   this.pending = true;
  //   response.subscribe(
  //     (response) => {
  //       if(response.token){
  //         sessionStorage.setItem('token', response.token);
  //         this.router.navigate(['/home']);
  //       }

  //     }
  //   );
  //   this.pending = false;
  }
}
