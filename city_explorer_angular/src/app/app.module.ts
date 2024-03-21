import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
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
import { TopPageComponent } from './city/top-page/top-page.component';
import { ContributorSectionComponent } from './home/contributor-section/contributor-section.component';
import { HotelsSectionComponent } from './home/hotels-section/hotels-section.component';
import { CopyrightComponent } from './shared-component/copyright/copyright.component';
import { AllCitiesComponent } from './city/all-cities/all-cities.component';
import { CityDetailsComponent } from './city/city-details/city-details.component';
import { AuthInterceptor } from './helpers/interceptors/auth.interceptor';
import { CommentComponent } from './comment/comment/comment.component';
import { MyProfileComponent } from './account/my-profile/my-profile.component';
import { EditeProfileComponent } from './account/edite-profile/edite-profile.component';

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
    OurServiceComponent,
    TopPageComponent,
    ContributorSectionComponent,
    HotelsSectionComponent,
    CopyrightComponent,
    AllCitiesComponent,
    CityDetailsComponent,
    CommentComponent,
    MyProfileComponent,
    EditeProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    
    {
      provide:HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi : true
      }
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
