import { Component } from '@angular/core';
import { CityService } from '../city.service';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent {
  selectedFiles: FileList | null = null;
  cityInfo: any = {};
  carouselImages: string[] = [];
  loading = false; // Flag to track loading state

  constructor(private cityService: CityService) { }

  addCity() {
    this.loading = true; // Set loading to true when submitting form
    const formData = new FormData();
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        formData.append('images', this.selectedFiles[i]);
      }
    }
    formData.append('name', this.cityInfo.name);
    formData.append('description', this.cityInfo.description);
    this.cityService.addNewCity(formData).subscribe(data => {
      console.log(data);
      this.loading = false; // Set loading to false when request completes
    }, error => {
      console.log(error);
      this.loading = false; // Set loading to false in case of error
    });
  }

  onFileSelected(event: any) {
    this.selectedFiles = event.target.files;
    this.carouselImages = [];
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        const reader = new FileReader();
        reader.onload = () => {
          this.carouselImages.push(reader.result as string);
        };
        reader.readAsDataURL(this.selectedFiles[i]);
      }
    }
  }
}
