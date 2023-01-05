import { TutordataComponent } from './components/tutors/tutordata/tutordata.component';
import { TutorregisterPagesComponent } from './pages/tutorregister-pages/tutorregister-pages.component';
import { TutorregisterformComponent } from './components/forms/tutorregisterform/tutorregisterform.component';
import { ChangetutorcompanyComponent } from './components/tutors/changetutorcompany/changetutorcompany.component';
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
import { RegistercompanyComponent } from './components/tutors/registercompany/registercompany.component';
import { DeletecompanyComponent } from './components/tutors/deletecompany/deletecompany.component';

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
    path: 'tutorregister',
    component: TutorregisterPagesComponent,
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
        path:'registercompany',
        component: RegistercompanyComponent,
        canActivate: [AuthGuard],
      },
      {
        path:'deletecompany',
        component: DeletecompanyComponent,
        canActivate: [AuthGuard],
      },
      {
        path:'changetutor',
        component: ChangetutorcompanyComponent,
        canActivate: [AuthGuard],
      },
      {
        path:'tutordata',
        component: TutordataComponent,
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
