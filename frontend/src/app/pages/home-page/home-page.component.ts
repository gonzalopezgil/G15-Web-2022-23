import { Component,OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {

  constructor(private router: Router) {};

  ngOnInit(): void {
    let user_type= 1;
    switch ( user_type ) {
      case 1:
        this.router.navigate(['/dashboard-users']);
        break;
      case 2:
      case 3:
      default:
        alert("Error al encontrar el tipo de usuario.");
        break;
   }
  }

}
