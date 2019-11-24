import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { t } from '@angular/core/src/render3';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  cafedetails:CafeDetails[];
  location:string;
  locations:string[] = [];
  found:boolean=false;
  error:any;

  constructor(private service:CafedetailsService, private route:Router) { }

  ngOnInit() {
    this.service.listCafeForUsers().subscribe(data => this.cafedetails=data);
    this.getUniqueLocation();
  }

  searchByLocationForUsers() {
    this.service.searchCafeByLocationForUsers(this.location).subscribe( data =>
      {
        this.cafedetails=data,
        data => this.error=data;
        if(this.cafedetails != undefined ) {
          this.found=true;
          console.log(this.found);
        } 
      });
  }

  sortRating() {
    this.cafedetails = this.service.sortCafeRating(this.cafedetails);
  }

  getUniqueLocation() {
    this.service.fetchUniqueLocations().subscribe(data => this.locations =data);
    console.log(this.locations);
  }

  yourOrders(){
    this.route.navigate(['your-orders']);
  }




  viewMenu(cafe : CafeDetails) {

    this.service.saveCafeDetail(cafe);
    console.log(cafe);
    this.route.navigate(['cafe-menu']);
  }

  giveRating(cafe){
    this.service.saveCafeDetail(cafe);
    console.log(this.service.userCafe);
    this.route.navigate(['view-feedback'])
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
      this.route.navigate(['admin-cafedetails'])
    }
  }

  goYourOrders(){
    this.route.navigate(['your-orders']);
  }

  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk(){
    this.route.navigate(['user-helpdesk']);
  }
  
}
