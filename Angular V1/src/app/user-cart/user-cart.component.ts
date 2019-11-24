import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../model/cafemenu.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { t } from '@angular/core/src/render3';
import { OrderDetailModel } from '../model/orderdetails';

@Component({
  selector: 'app-user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {

  item:CafeMenu;
  items:CafeMenu[]=[];
  orderDetails : OrderDetailModel[] = [];
  orderDetail : OrderDetailModel;
  price : number = 0;

  constructor(private service:CafedetailsService, private route:Router) { }

  ngOnInit() {
    this.demo();
    this.calculatePriceForItems();
  }

  demo() {
    this.items=this.service.item;
    console.log(this.items);
    
    console.log(this.item);
    this.service.saveCafeMenu(this.items);
  }

  calculatePriceForItems(){
    this.items.forEach(element => {
      this.orderDetail = new OrderDetailModel();
      this.orderDetail.itemId = element.itemId;
      this.orderDetail.itemName = element.itemName;
      this.orderDetail.itemPrice = element.itemPrice;
      this.orderDetail.itemType = element.itemType;
      this.orderDetail.quantity = element.quantity;
      this.orderDetail.itemTotal = this.price + this.orderDetail.quantity * this.orderDetail.itemPrice;
      this.orderDetails.push(this.orderDetail);
      this.service.saveOrderDetails(this.orderDetails);
    });
    console.log(this.orderDetails);
  }

  goToOrder() {
    this.route.navigate(['place-order']);
  }

  goToItem(){

    this.route.navigate(['cafe-menu']);
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

  yourOrders(){
    this.route.navigate(['your-orders']);
  }




  delete(index : number)
  {
    var ans = confirm("Are You Sure You Want To Delete ?")
    if(ans)
    { 
      console.log(index);
      this.orderDetails.splice(index,1);
    }
  }


}
