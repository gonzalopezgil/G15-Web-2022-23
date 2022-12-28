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
import { NavigationUsersComponent } from './components/navigation-users/navigation-users.component';
import { DashboardUsersComponent } from './pages/dashboard-users/dashboard-users.component';
import { PracticesComponent } from './components/practices/practices.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PopUpComponent } from './components/pop-up/pop-up.component';

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
    PopUpComponent
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
