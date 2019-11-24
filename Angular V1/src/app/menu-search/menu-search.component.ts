import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../model/cafemenu.model';
import { MenuServicesService } from '../menu-services/menu-services.service';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-search',
  templateUrl: './menu-search.component.html',
  styleUrls: ['./menu-search.component.css']
})
export class MenuSearchComponent implements OnInit {

  item:CafeMenu[]=[];
  itemName:string;
  found:boolean=false;
  error:any;

  constructor(private cafeService:CafedetailsService, private service:MenuServicesService, private route : Router) { }

  ngOnInit() {
  }

  searchMenu() {
    this.service.searchMenuItem(this.itemName).subscribe(data =>{ this.item=data; console.log(this.item);}, data => this.error=data);
    if(this.item != null || this.item.length ==0)
      this.found=true;
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
    if(this.cafeService.role()=="USER"){
      this.route.navigate(['user-cafedetails'])
    }
    if(this.cafeService.role()=="ADMIN"){
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
