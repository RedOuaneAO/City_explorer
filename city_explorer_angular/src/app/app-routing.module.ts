import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { HomeComponent } from './home/home/home.component';
import { FoodSectionComponent } from './home/food-section/food-section.component';
import { CityComponent } from './city/city/city.component';
import { TopPageComponent } from './city/top-page/top-page.component';
import { SigninGuard } from './helpers/guards/signin.guard';
import { AuthGuard } from './helpers/guards/auth.guard';
import { MyProfileComponent } from './account/my-profile/my-profile.component';

const routes: Routes = [
  {path:'' , component:HomeComponent},
  {path:'signup' , component:SignupComponent},
  {path:'signin' , component:SigninComponent,canActivate:[SigninGuard]},
  {path:'cities' , component:TopPageComponent,canActivate:[AuthGuard]},
  {path:'food' , component:FoodSectionComponent},
  {path:'city' , component:CityComponent},
  {path:'profile' , component:MyProfileComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
