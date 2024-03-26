import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-edite-profile',
  templateUrl: './edite-profile.component.html',
  styleUrl: './edite-profile.component.css'
})
export class EditeProfileComponent {
  token:String | null="";
  userInfo:any ={};
  oldPassword :String="";
  constructor(private accountService :AccountService,private router:Router){}

  ngOnInit(){
    this.token = localStorage.getItem("token");
    this.accountService.getUser(this.token).subscribe((data)=>{
      this.userInfo = data
      console.log(this.userInfo.firstName);
    },(error)=>{
      console.log("the user doesn't exist");
      
    })
  }
  updateProfile(){
      Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, i'm sure!"
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire({
            title: 'Success!',
            imageUrl:"https://media.tenor.com/2fDPAEGo1vAAAAAM/alfred-marko.gif",
            text: 'Your profile has been updated succcessfuly',
            confirmButtonText: 'Cool',
            timer: 1500
          })
        }else{
          Swal.fire({
            title: 'good by!',
            imageUrl:"https://i.pinimg.com/736x/c8/cd/8e/c8cd8eb3c08b21ed6777bd3cc46e73f8.jpg",
            text: 'thank you for your comming',
            imageWidth: 300,
            imageHeight: 300,
            confirmButtonText: 'Cool',
            timer: 2000
          })
        }
      });
    
    
  }

}
