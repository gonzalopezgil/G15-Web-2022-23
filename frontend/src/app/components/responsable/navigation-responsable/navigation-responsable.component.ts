import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-navigation-responsable',
  templateUrl: './navigation-responsable.component.html',
  styleUrls: ['./navigation-responsable.component.scss']
})
export class NavigationResponsableComponent {
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  constructor(private breakpointObserver: BreakpointObserver, private router: Router,private AuthService: AuthService) { }

    ngOnInit(): void {
      this.router.navigate(['dashboard-responsable/welcome']);
    }
  
    logout(): void {
      this.AuthService.logout();
      this.router.navigate(['login']);
    }
  
  }
}
