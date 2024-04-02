import { Component } from '@angular/core';
import { CityService } from '../city.service';

@Component({
  selector: 'app-all-cities',
  templateUrl: './all-cities.component.html',
  styleUrl: './all-cities.component.css'
})
export class AllCitiesComponent {
  cities:any[] =[]; 
  constructor(private cityService:CityService){}
  ngOnInit(){
    this.getAllCities()
  }
  getAllCities(){
    this.cityService.getAllCities().subscribe(data=>{
      this.cities=data
      console.log(this.cities);
    })

  }
}
