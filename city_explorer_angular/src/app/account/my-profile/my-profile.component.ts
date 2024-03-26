import { Component } from '@angular/core';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrl: './my-profile.component.css'
})
export class MyProfileComponent {
  activeTab: string = 'cities'; 
    
  showCities() {
      this.activeTab = 'cities';
  }
  showHotels() {
      this.activeTab = 'hotels';
  }
  showFood() {
      this.activeTab = 'food';
  }
}
