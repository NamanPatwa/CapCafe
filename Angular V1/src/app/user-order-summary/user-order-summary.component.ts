import { Component, OnInit } from '@angular/core';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { OrderModel } from '../model/order';

@Component({
  selector: 'app-user-order-summary',
  templateUrl: './user-order-summary.component.html',
  styleUrls: ['./user-order-summary.component.css']
})
export class UserOrderSummaryComponent implements OnInit {

  order : OrderModel;

  constructor(private service : CafedetailsService, private route : Router) { }

  ngOnInit() {
    this.order = this.service.selectedOrder;
  }

  goHome(){
    this.route.navigate(['user-cafedetails'])
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
  
  yourOrders(){
    this.route.navigate(['your-orders']);
  }




  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk(){
    this.route.navigate(['user-helpdesk']);
  }




}
