import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../model/order';
import { OrderDetailModel } from '../model/orderdetails';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-list-orders',
  templateUrl: './admin-list-orders.component.html',
  styleUrls: ['./admin-list-orders.component.css']
})
export class AdminListOrdersComponent implements OnInit {

  order:OrderModel[];
  collection:OrderDetailModel[];
  constructor(private service:CafedetailsService,private route:Router) { }

  ngOnInit() {
    this.service.listOrder().subscribe(data => this.order=data);
    console.log(this.order);
  }
  view(order : OrderModel)
  {
      let id = order.orderId;
      console.log(id);
      this.route.navigate(['admin-view-orderdetails', id]);
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
