import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-users',
  templateUrl: './navigation-users.component.html',
  styleUrls: ['./navigation-users.component.scss']
})
export class NavigationUsersComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private router: Router) {}

  logout(): void {
    sessionStorage.removeItem('token');
    this.router.navigate(['login']);
  }

}
