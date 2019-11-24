import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  cafedetails:CafeDetails[];
  location:String;
  found:boolean=false;
  error:any;

  constructor(private service:CafedetailsService, private route:Router) { }

  ngOnInit() {
    this.service.listCafe().subscribe(data => this.cafedetails=data);
  }

  delete(cafe: CafeDetails) {
    var ans = confirm("Are you sure you want to delete?")
    if(ans) {
      this.service.deleteCafe(cafe.cafeId).subscribe(data =>this.cafedetails = this.cafedetails.filter(u => u !==cafe)) //Delete from service
    }
  }

  searchByLocation() {
    this.service.searchCafeByLocation(this.location).subscribe(data => this.cafedetails=data, data => this.error=data);
    if(this.cafedetails != null || this.cafedetails.length > 0 )
      this.found=true;
  }

  goToAddCafe() {
    this.route.navigate(['add']);
  }

  goToEditCafe() {
    this.route.navigate(['update']);
  }

  sortRating() {
    this.cafedetails = this.service.sortCafeRating(this.cafedetails);
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
