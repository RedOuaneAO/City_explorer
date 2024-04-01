import { Component } from '@angular/core';
import { CityService } from '../city.service';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrl: './new-city.component.css'
})
export class NewCityComponent {
  selectedFiles!: FileList ;
  cityInfo:any ={};
  constructor(private cityService : CityService) { }


  addCity() {
    const formData = new FormData();
    for (let i = 0; i < this.selectedFiles.length; i++) {
      formData.append('images', this.selectedFiles[i]);
    }
    formData.append('name', this.cityInfo.name);
    formData.append('description', this.cityInfo.description);
    this.cityService.addNewCity(formData).subscribe(data => {
      console.log(data);
    }, error => {
      console.log(error);
    });
  }

  onFileSelected(event: any) {
    this.selectedFiles = event.target.files;
    console.log(this.selectedFiles);
  }
}
