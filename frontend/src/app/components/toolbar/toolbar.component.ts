import { Component } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent {

  isLoggedIn: Boolean = false;

  constructor() {
    if (sessionStorage.getItem('token')) {
      this.isLoggedIn = true;
    }
  }


}
