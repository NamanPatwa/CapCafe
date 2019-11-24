import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../model/cafemenu.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-menu',
  templateUrl: './list-menu.component.html',
  styleUrls: ['./list-menu.component.css']
})
export class ListMenuComponent implements OnInit {

  menus:CafeMenu[];
  found:boolean=false;
  item:CafeMenu[]=[];
  itemName : string;
  error : any;

  public getItem() {
    return this.item;
  }

  constructor(private service:CafedetailsService, private route:Router) { }

  ngOnInit() {
    this.service.listMenu().subscribe(data =>
      {
        this.menus=data;
        this.service.saveCafeMenu(this.menus);
      });
  }

  addToCafe(menu:CafeMenu) {
      console.log(this.item.push(menu));
      console.log(this.item);
      console.log(this.service.saveCafeMenu(this.item));

  }

  redirectToAddCafe() {
     this.route.navigate(['add']);
  }

  delete(item: CafeMenu) {
    var ans = confirm("Are you sure you want to delete?")
    if(ans) {
      this.service.deleteMenuItem(item.itemId).subscribe(data =>{this.item = this.item.filter(u => u !==item);
      this.ngOnInit();
      }) //Delete from service
    }
  }

  searchMenu() {
    this.service.searchMenuItem(this.itemName).subscribe(data => this.menus =data, data => this.error=data);
    console.log(this.item);
    if(this.menus != null || this.menus.length == 0)
      this.found=true;
  }

  goEdit(){
    this.route.navigate(['menu-edit']);
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
