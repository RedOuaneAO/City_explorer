import { Component } from '@angular/core';
import { CityService } from '../city.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrl: './city.component.css'
})
export class CityComponent {
  cityId: number=0;
  cityDetails:any={};
  constructor(private cityService:CityService,private route: ActivatedRoute){}
    ngOnInit() {
      this.extractCityId();
      this.getCityDetails();
    }
    
    extractCityId(){
      this.route.paramMap.subscribe(params => {
        if (params.has('id')) {
          this.cityId = parseInt(params.get('id')!, 10); 
        }
      });
    }
    getCityDetails(){
      this.cityService.getCityById(this.cityId).subscribe(data=>{
        this.cityDetails=data
        console.log(this.cityDetails);
        
      })
    }

  
}
