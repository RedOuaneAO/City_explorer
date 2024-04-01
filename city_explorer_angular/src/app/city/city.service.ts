import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http:HttpClient) { }

  addNewCity(cityInfo:any):Observable<any>{
      return this.http.post(environment.apiURL+'addcity',cityInfo)
  }

}
