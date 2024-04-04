import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-city-details',
  templateUrl: './city-details.component.html',
  styleUrl: './city-details.component.css'
})
export class CityDetailsComponent {
  @Input() cityDetails: any ={}

  ngOnInit(){
    console.log(this.cityDetails);
    
  }
}
