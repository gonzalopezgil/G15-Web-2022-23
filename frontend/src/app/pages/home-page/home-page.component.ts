import { UsersService } from 'src/app/services/users.service';
import { Component,OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit{

  constructor(private router: Router,private UsersService: UsersService) {};

  ngOnInit(): void {
    // let user_type = this.UsersService.user_type();
    // if(user_type == '1'){
    //   this.router.navigate(['dashboard-users']);
    // }else if (user_type == '2'){
    //   this.router.navigate(['dashboard-tutors']);
    // }
    // const helper = new JwtHelperService();
    // let token = sessionStorage.getItem('token');
    // if (token){
    //   let decodedToken = helper.decodeToken(token);
    //   console.log(decodedToken["CLAIM_TOKEN"])
    // }

  }
}


