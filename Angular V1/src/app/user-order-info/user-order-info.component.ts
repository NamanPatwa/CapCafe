import { Component, OnInit } from '@angular/core';
import { OrderDetailModel } from '../model/orderdetails';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { OrderModel } from '../model/order';

@Component({
  selector: 'app-user-order-info',
  templateUrl: './user-order-info.component.html',
  styleUrls: ['./user-order-info.component.css']
})
export class UserOrderInfoComponent implements OnInit {

  collection:OrderDetailModel[] =[];
  price : number;
  order : OrderModel;

  constructor(private service : CafedetailsService, private route: Router) { }

  ngOnInit() {
    this.collection = this.service.orderDetails;
    this.order = this.service.orderedOrder;
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
