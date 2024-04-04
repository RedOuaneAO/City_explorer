import { Component, Input } from '@angular/core';
import { HotelService } from '../../hotel/hotel.service';

@Component({
  selector: 'app-city-details',
  templateUrl: './city-details.component.html',
  styleUrl: './city-details.component.css'
})
export class CityDetailsComponent {
  @Input() cityDetails: any ={}
  hotels:any[] =[]; 
  constructor(private hotelService:HotelService){}

  ngOnInit(){
    console.log(this.cityDetails.id);
    this.getAllHotels();
  }
  getAllHotels(){
    this.hotelService.getAllHotelsByCityId(this.cityDetails.id).subscribe(data=>{
      this.hotels=data
      console.log(data[0].images[0].imageUrl);
      
    })

  }
}
