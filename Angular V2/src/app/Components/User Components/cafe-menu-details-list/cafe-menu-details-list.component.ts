import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../../../model/cafedetails.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CafeMenu } from '../../../model/cafemenu.model';
import { OrderDetailModel } from '../../../model/orderdetails';

@Component({
  selector: 'app-cafe-menu-details-list',
  templateUrl: './cafe-menu-details-list.component.html',
  styleUrls: ['./cafe-menu-details-list.component.css']
})
export class CafeMenuDetailsListComponent implements OnInit {

  items: CafeDetails[];
  menus: CafeMenu[] = [];
  sub;
  id: number;
  cafe: CafeDetails;
  orderDetail: OrderDetailModel;
  quantity: number;

  constructor(private route: ActivatedRoute, private route1: Router, private service: CafedetailsService) { }

  ngOnInit() {
    this.cafe = this.service.userCafe;
  }



  addToCart(item: CafeMenu) {
    this.service.saveCafeItem(item);
    this.menus.push(item);
    //this.service.saveCafeMenu();
    console.log(this.menus);
    this.service.saveCafeMenu(this.menus);
    console.log(this.menus);

    //this.route1.navigate(['user-cart']);
  }

  goCart() {
    this.route1.navigate(['user-cart']);
  }

  navigateResetPassword() {
    this.route1.navigate(['resetpassword']);
  }

  logout() {
    sessionStorage.removeItem('role');
    this.route1.navigate(['login']);
  }

  profile() {
    this.route1.navigate(['profile']);
  }

  yourOrders() {
    this.route1.navigate(['your-orders']);
  }




  home() {
    if (this.service.role() == "USER") {
      this.route1.navigate(['user-cafedetails'])
    }
    if (this.service.role() == "ADMIN") {
      this.route1.navigate(['admin-cafedetails'])
    }
  }

  goYourOrders() {
    this.route1.navigate(['your-orders']);
  }

  mapList() {
    this.route1.navigate(['user-list']);
  }

  goHelpdesk() {
    this.route1.navigate(['user-helpdesk']);
  }
  viewFeedback(item: CafeMenu) {
    this.service.itemfororder = item;
    console.log(this.service.itemfororder);
    this.route1.navigate(['view-item-feedback']);
  }



}
