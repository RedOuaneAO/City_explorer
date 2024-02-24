import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home/home.component';
import { NavBarComponent } from './shared-component/nav-bar/nav-bar.component';
import { SigninComponent } from './auth/signin/signin.component';
import { SignupComponent } from './auth/signup/signup.component';
import { CitySectionComponent } from './home/city-section/city-section.component';
import { FooterComponent } from './home/footer/footer.component';
import { CityComponent } from './city/city/city.component';
import { FoodSectionComponent } from './home/food-section/food-section.component';
import { AboutUsComponent } from './home/about-us/about-us.component';
import { OurServiceComponent } from './home/our-service/our-service.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    SigninComponent,
    NavBarComponent,
    HomeComponent,
    CitySectionComponent,
    FooterComponent,
    CityComponent,
    FoodSectionComponent,
    AboutUsComponent,
    OurServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
