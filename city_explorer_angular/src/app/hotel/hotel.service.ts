import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http:HttpClient) { }

  getAllHotels():Observable<any>{
    return this.http.get(environment.apiURL+'hotels')
  }
  getAllHotelsByCityId(cityId:number):Observable<any>{
    return this.http.get(environment.apiURL+'cityHotels/'+ cityId)
  }
  addNewHotel(hotelInfo:any):Observable<any>{
    return this.http.post(environment.apiURL+'addHotel',hotelInfo)
}
}
