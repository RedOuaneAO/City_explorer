import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent {
  loginForm:any={};
  errorMessage:String = "";
  constructor(private authService : AuthService,private router:Router){}

  loing(){
     console.log(this.loginForm);
     this.authService.authenticate(this.loginForm).subscribe((data)=>{
      console.log(data.token);
      localStorage.setItem("token", data.token)
      localStorage.setItem("authorities", data.authorities);
      this.router.navigate(["/cities"])
     },(error)=>{
      console.log(error.error.message);
      this.errorMessage =error.error.message;
     })
     
  }
}
