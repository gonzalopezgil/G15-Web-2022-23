import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  loadingState: Boolean = false;
  loginError: String = "";

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    let token = sessionStorage.getItem('token');
    if (token) {
      this.router.navigate(['/home']);
    }
  }



  loginUser(value: any): void {
    let { username, password } = value;

    this.loadingState = true;

    this.authService.login(username,password).subscribe(
      (response) => {
        console.log(response);
        if(response.token){
          sessionStorage.setItem('token', response.token);
          this.router.navigate(['/home']);
        }
      },
      (error) => {
        if (error.status === 401)
          this.loginError = "Las credenciales no son validas"
          this.loadingState = false;
      },
      () => {
        this.loginError = "";
        this.loadingState = false;
      });
  }
}
