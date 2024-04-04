import { Component } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-all-hotels',
  templateUrl: './all-hotels.component.html',
  styleUrl: './all-hotels.component.css'
})
export class AllHotelsComponent {
  hotels:any[] =[]; 
  constructor(private hotelService:HotelService){}
  ngOnInit(){
    this.getAllHotels()
  }
  getAllHotels(){
    this.hotelService.getAllHotels().subscribe(data=>{
      this.hotels=data
      console.log(this.hotels);
    })

  }
}
