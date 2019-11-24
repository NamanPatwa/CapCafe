import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  cafedetail:CafeDetails;
  cafedetails:CafeDetails[];
  locations:string[] = [];
  id:number;
  location:string;
  found:boolean=false;
  error:any;

  constructor(private service:CafedetailsService, private route:Router) { }

  ngOnInit() {
    this.getUniqueLocation();
  }

  // searchById() {
  //   this.service.searchCafeById(this.id).subscribe(data => this.cafedetail=data, data => this.error=data);
  //   if(this.cafedetail != null)
  //     this.found=true;
  // }

  searchByLocation() {
    this.service.searchCafeByLocationForUsers(this.location).subscribe( data =>
      {
        this.cafedetails=data,
        data => this.error=data;
        if(this.cafedetails != undefined ) {
          this.found=true;
          console.log(this.found);
        } 
        // else {
        //   this.found=false;
        //   console.log(this.found);
        // }
      });
  }

  sortRating() {
    this.cafedetails = this.service.sortCafeRating(this.cafedetails);
  }

  getUniqueLocation() {
    this.service.fetchUniqueLocations().subscribe(data => this.locations =data);
    console.log(this.locations);
  }

  viewMenu(cafe : CafeDetails) {
    this.service.selectedCafe = cafe;
    this.route.navigate(['admin-menu-list']);
  }

  navigateResetPassword(){
    this.route.navigate(['resetpassword']); 
  }

  logout(){
    sessionStorage.removeItem('role');
    this.route.navigate(['login']); 
  }

  profile(){
    this.route.navigate(['profile']); 
  }

  home(){
    if(this.service.role()=="USER"){
      this.route.navigate(['user-cafedetails'])
    }
    if(this.service.role()=="ADMIN"){
      this.route.navigate(['admin-home'])
    }
  }

  goCafeManagement() {
    this.route.navigate(['admin-cafedetails']);
  }

  goMenuManagement() {
    this.route.navigate(['admin-menu']);
  }

  goHelpdesk() {
    this.route.navigate(['admin-helpdesk']);
  }

  goOrderManagement() {
    this.route.navigate(['admin-list-orders']);
  }

  getall(){
    this.route.navigate(['getall']);  
  }

}
