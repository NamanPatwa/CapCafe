import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { CafeMenu } from '../model/cafemenu.model';
import { ListMenuComponent } from '../list-menu/list-menu.component';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  cafe:CafeDetails;
  cafeId:number;
  menus:CafeMenu[];
  public cafeMenus:CafeMenu[];
  item:CafeMenu[]=[];

  constructor(private service:CafedetailsService, private route:Router) {
    this.cafe = new CafeDetails()
   }

  ngOnInit() {
  }

  add() {
    // this.menus = this.service.cafeMenus;
    // console.log(this.menus);
    this.item=this.service.item;
     console.log(this.item);
    this.cafe.menus = this.item;
    console.log(this.cafe);
    this.service.saveCafe(this.cafe).subscribe(data => this.cafe=data);
    this.cafe=new CafeDetails();
    this.route.navigate(['search']);
  }

  addCafeWithMenu() {
    this.route.navigate(['list-menu']);
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
      this.route.navigate(['user-cafedetails']);
    }
    if(this.service.role()=="ADMIN"){
      this.route.navigate(['admin-home']);
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
