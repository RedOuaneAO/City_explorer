import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { HomeComponent } from './home/home/home.component';
import { FoodSectionComponent } from './home/food-section/food-section.component';
import { CityComponent } from './city/city/city.component';

const routes: Routes = [
  {path:'' , component:HomeComponent},
  {path:'signup' , component:SignupComponent},
  {path:'signin' , component:SigninComponent},
  {path:'cities' , component:CityComponent},
  {path:'food' , component:FoodSectionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
