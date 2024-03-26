import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http : HttpClient) { }
  authenticate(userData:any):Observable<any>{
    return this.http.post(environment.apiURL+'auth/authenticate',userData);
  }
  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }
}
