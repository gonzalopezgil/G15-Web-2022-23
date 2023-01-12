import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Observable, map, shareReplay } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navigation-tutors',
  templateUrl: './navigation-tutors.component.html',
  styleUrls: ['./navigation-tutors.component.scss']
})
export class NavigationTutorsComponent  implements OnInit{


  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private router: Router,private AuthService: AuthService) { }

  ngOnInit(): void {
    this.router.navigate(['dashboard-tutors/welcome']);
  }

  logout(): void {
    this.AuthService.logout();
    this.router.navigate(['login']);
  }

}
