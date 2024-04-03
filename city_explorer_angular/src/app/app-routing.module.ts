import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { HomeComponent } from './home/home/home.component';
import { CityComponent } from './city/city/city.component';
import { TopPageComponent } from './city/top-page/top-page.component';
import { SigninGuard } from './helpers/guards/signin.guard';
import { AuthGuard } from './helpers/guards/auth.guard';
import { MyProfileComponent } from './account/my-profile/my-profile.component';
import { EditeProfileComponent } from './account/edite-profile/edite-profile.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NewCityComponent } from './city/new-city/new-city.component';
import { AllFoodTopPageComponent } from './food/all-food-top-page/all-food-top-page.component';

const routes: Routes = [
  {path:'' , component:HomeComponent},
  {path:'signup' , component:SignupComponent},
  {path:'signin' , component:SigninComponent,canActivate:[SigninGuard]},
  {path:'cities' , component:TopPageComponent,canActivate:[AuthGuard]},
  {path:'city' , component:CityComponent},
  {path:'profile' , component:MyProfileComponent},
  {path:'editeProfile' , component:EditeProfileComponent,canActivate:[AuthGuard]},
  {path:'dashboard' , component:DashboardComponent},
  {path:'addCity' , component:NewCityComponent},
  {path:'food' , component:AllFoodTopPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
