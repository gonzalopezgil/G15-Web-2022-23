import { UsersService } from 'src/app/services/users.service';
import { Component,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit{

  constructor(private router: Router,private authService: AuthService) {};

  ngOnInit(): void {
    // let user_type = this.UsersService.user_type();
    // if(user_type == '1'){
    //   this.router.navigate(['dashboard-users']);
    // }else if (user_type == '2'){
    //   this.router.navigate(['dashboard-tutors']);
    // }

    let role = this.authService.getRole();
    switch(role){
      case 'ROLE_STUDENT':
        this.router.navigate(['dashboard-users']);
        break;
      case 'ROLE_TUTOR':
        this.router.navigate(['dashboard-tutors']);
        break;
      case 'ROLE_SUPERVISOR':
        this.router.navigate(['dashboard-responsable']);
        break;
      default:
        this.router.navigate(['login']);
    }

  }
}


