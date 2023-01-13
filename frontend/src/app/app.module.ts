// Module imports
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material/material.module';
import { HttpClientModule } from '@angular/common/http';
//Module forms imports
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// Component imports
import { AppComponent } from './app.component';
import { LoginFormComponent } from './components/forms/login-form/login-form.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { NavigationUsersComponent } from './components/users/navigation-users/navigation-users.component';
import { DashboardUsersComponent } from './pages/dashboard-users/dashboard-users.component';
import { PracticesComponent } from './components/users/practices/practices.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PopUpPracticesComponent } from './components/pop-ups/pop-up-practices/pop-up-practices.component';
import { ReportsComponent } from './components/users/reports/reports.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PracticesOngoingComponent } from './components/users/practices-ongoing/practices-ongoing.component';
import { UserdataComponent } from './components/users/userdata/userdata.component';
import { PopUpPasswordComponent } from './components/pop-ups/pop-up-password/pop-up-password.component';
import { NavigationResponsableComponent } from './components/responsable/navigation-responsable/navigation-responsable.component';
import { ResponsabledataComponent } from './components/responsable/responsabledata/responsabledata.component';
import { UsersReportsComponent } from './components/responsable/users-reports/users-reports.component';
import { DashboardResponsableComponent } from './pages/dashboard-responsable/dashboard-responsable.component';
import { AssignPracticeComponent } from './components/responsable/assign-practice/assign-practice.component';
import { PopUpAssignPracticesComponent } from './components/pop-ups/pop-up-assign-practices/pop-up-assign-practices.component';
import { AboutUsPageComponent } from './pages/about-us-page/about-us-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { RegisterFormComponent } from './components/forms/register-form/register-form.component';
import { PasswordsMatchValidator } from './validators/passwords-match-validator/passwords-match-validator.component';
import { DashboardTutorsComponent } from './pages/dashboard-tutors/dashboard-tutors.component';
import { NavigationTutorsComponent } from './components/tutors/navigation-tutors/navigation-tutors.component';
import { RegisterofferComponent } from './components/tutors/registeroffer/registeroffer.component';
import { DeletecompanyComponent } from './components/tutors/deletecompany/deletecompany.component';
import { ChangetutorcompanyComponent } from './components/tutors/changetutorcompany/changetutorcompany.component';
import { TutorregisterformComponent } from './components/forms/tutorregisterform/tutorregisterform.component';
import { TutorregisterPagesComponent } from './pages/tutorregister-pages/tutorregister-pages.component';
import { PopUpTutorregisterComponent } from './components/pop-ups/pop-up-tutorregister/pop-up-tutorregister.component';
import { TutordataComponent } from './components/tutors/tutordata/tutordata.component';
import { TutorreportsComponent } from './components/tutors/tutorreports/tutorreports.component';
import { RegistercompanyComponent } from './components/tutors/registercompany/registercompany.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    DashboardUsersComponent,
    LoginPageComponent,
    ToolbarComponent,
    NavigationUsersComponent,
    PracticesComponent,
    HomePageComponent,
    PopUpPracticesComponent,
    ReportsComponent,
    WelcomeComponent,
    PracticesOngoingComponent,
    UserdataComponent,
    PopUpPasswordComponent,
    NavigationResponsableComponent,
    ResponsabledataComponent,
    UsersReportsComponent,
    DashboardResponsableComponent,
    AssignPracticeComponent,
    PopUpAssignPracticesComponent,
    AboutUsPageComponent,
    RegisterPageComponent,
    RegisterFormComponent,
    PasswordsMatchValidator,
    DashboardTutorsComponent,
    NavigationTutorsComponent,
    RegisterofferComponent,
    DeletecompanyComponent,
    ChangetutorcompanyComponent,
    TutorregisterformComponent,
    TutorregisterPagesComponent,
    PopUpTutorregisterComponent,
    TutordataComponent,
    TutorreportsComponent,
    RegistercompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
