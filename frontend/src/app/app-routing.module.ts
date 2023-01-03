
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardUsersComponent } from './pages/dashboard-users/dashboard-users.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { AuthGuard } from './guards/auth.guard';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PracticesComponent } from './components/users/practices/practices.component';
import { ReportsComponent } from './components/users/reports/reports.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PracticesOngoingComponent } from './components/users/practices-ongoing/practices-ongoing.component';
import { UserdataComponent } from './components/users/userdata/userdata.component';
import { DashboardTutorsComponent } from './pages/dashboard-tutors/dashboard-tutors.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full',
  },
  {
    path: 'home',
    component: HomePageComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'login',
    component: LoginPageComponent,
  },
  {
    path: 'dashboard-tutors',
    component: DashboardTutorsComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'welcome',
        component: WelcomeComponent,
        canActivate: [AuthGuard],
      },
      {
        path: '',
        redirectTo: 'welcome',
        pathMatch: 'full',
      },
    ],
  },
  {
    path: 'dashboard-users',
    component: DashboardUsersComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'welcome',
        component: WelcomeComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'practices',
        component: PracticesComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'reports',
        component: ReportsComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'practicesongoing',
        component: PracticesOngoingComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'userdata',
        component: UserdataComponent,
        canActivate: [AuthGuard],
      },
      {
        path: '',
        redirectTo: 'welcome',
        pathMatch: 'full',
      },
    ],
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
