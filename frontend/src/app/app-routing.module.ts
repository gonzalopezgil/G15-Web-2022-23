import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardUsersComponent } from './pages/dashboard-users/dashboard-users.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { AuthGuard } from './guards/auth.guard';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PracticesComponent } from './components/practices/practices.component';

const routes: Routes = [
  { 
    path: '', 
    redirectTo: '/home', 
    pathMatch: 'full'
  },
  { 
    path: 'home', 
    component:HomePageComponent, 
    canActivate: [AuthGuard]
  },
  { 
    path: 'dashboard-users', 
    component: DashboardUsersComponent, 
    canActivate: [AuthGuard], 
    children:[
      {
        path: 'practices', 
        component: PracticesComponent, 
        canActivate: [AuthGuard]
      }
    ]
  },
  { 
    path: 'login', 
    component: LoginPageComponent 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
