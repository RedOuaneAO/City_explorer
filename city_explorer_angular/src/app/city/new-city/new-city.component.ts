import { Component } from '@angular/core';
import { CityService } from '../city.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.css']
})
export class NewCityComponent {
  selectedFiles!: FileList ;
  cityInfo: any = {};
  carouselImages: string[] = [];
  loading = false; 

  constructor(private cityService: CityService,private router :Router) { }

  addCity() {
    this.loading = true; 
    const formData = new FormData();
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        formData.append('images', this.selectedFiles[i]);
      }
    }
    formData.append('name', this.cityInfo.name);
    formData.append('description', this.cityInfo.description);
    this.cityService.addNewCity(formData).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "The City has been saved",
        showConfirmButton: false,
        timer: 1500
      });
      this.loading = false;
      this.router.navigate(['/cities'])
    }, error => {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Something went wrong! Please try again",
        timer: 1700
      });
      this.loading = false; 
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
