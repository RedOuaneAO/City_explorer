import { Component } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CityService } from '../../city/city.service';

@Component({
  selector: 'app-new-hotel',
  templateUrl: './new-hotel.component.html',
  styleUrl: './new-hotel.component.css'
})
export class NewHotelComponent {
  selectedFiles!: FileList ;
  hotelInfo: any = {};
  carouselImages: string[] = [];
  loading = false; 
  cities:any[] =[]; 
  selectedCity:number=0;


  constructor(private hotelService: HotelService,private router :Router,private cityService :CityService) { }
  ngOnInit(){
    this.getAllCities()
  }
  getAllCities(){
    this.cityService.getAllCities().subscribe(data=>{
      this.cities=data
    })
  }

  addHotel() {
    this.loading = true; 
    const formData = new FormData();
    if (this.selectedFiles) {
      for (let i = 0; i < this.selectedFiles.length; i++) {
        formData.append('images', this.selectedFiles[i]);
      }
    }
    this.hotelInfo['cityId']=this.selectedCity;
    formData.append('name', this.hotelInfo.name);
    formData.append('description', this.hotelInfo.description);
    formData.append('cityId', this.hotelInfo.cityId);
    this.hotelService.addNewHotel(formData).subscribe(data => {
      Swal.fire({
        icon: "success",
        title: "The City has been saved",
        showConfirmButton: false,
        timer: 1500
      });
      this.loading = false;
      this.router.navigate(['/hotels'])
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
