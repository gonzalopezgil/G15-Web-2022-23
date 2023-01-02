import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

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

  constructor(private breakpointObserver: BreakpointObserver, private router: Router,private AuthService: AuthService) { }

  ngOnInit(): void {
    this.router.navigate(['dashboard-users/welcome']);
  }

  logout(): void {
    this.AuthService.logout();
    this.router.navigate(['login']);
  }

}
