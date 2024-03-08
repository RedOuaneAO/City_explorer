import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {
  // 
    token:String | null="" 
    constructor(private router: Router){}
      ngOnInit(){
        this.token =localStorage.getItem("token");
      }
      logout(){
        localStorage.removeItem("token");
        this.router.navigate(["/"])
      }
}
