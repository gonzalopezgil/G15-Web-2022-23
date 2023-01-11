import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  isLoggedIn: Boolean = false;

  constructor(private authService: AuthService) {
    if (sessionStorage.getItem('token')) {
      this.isLoggedIn = true;
    }
  }

  logout() {
    this.authService.logout();
  }


}
