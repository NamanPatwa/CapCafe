import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../../../model/order';
import { OrderDetailModel } from '../../../model/orderdetails';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { Employee } from '../../../model/employee.model';
import { CafeDetails } from '../../../model/cafedetails.model';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {

  order: OrderModel;
  id: number;
  collection: OrderDetailModel[] = [];
  price: number = 0;
  employee: Employee;
  cafe: CafeDetails;
  payments: string[] = ["Credit Card", "Debit Card", "Cash"];

  constructor(private service: CafedetailsService, private route: Router) {
    this.order = new OrderModel();

  }

  ngOnInit() {
    this.collection = this.service.orderDetails;
    console.log(this.collection);
    this.calculateTotal();
    this.order.orderDetails = this.collection;
    console.log(this.order);
    this.employee = this.service.employee;
    this.cafe = this.service.userCafe;
    console.log(this.employee);
    this.order.employeeId = this.employee.employeeId;
    this.order.employeeMail = this.employee.employeeMail;
    this.order.employeeName = this.employee.employeeName;
    this.order.employeePhone = this.employee.employeePhone;
    this.order.location = this.cafe.cafeLocation;
  }

  calculateTotal() {
    this.collection.forEach(element => {
      this.price = this.price + element.itemTotal;
    });
    this.order.totalAmount = this.price;
  }

  addOrder() {
    this.service.saveOrder(this.order).subscribe(data => {
      this.id = data
      this.order = new OrderModel();
      this.route.navigate(['user-order-details']);
    });
    this.service.orderedOrder = this.order;
  }

  navigateResetPassword() {
    this.route.navigate(['resetpassword']);
  }

  logout() {
    sessionStorage.removeItem('role');
    this.route.navigate(['login']);
  }

  profile() {
    this.route.navigate(['profile']);
  }

  home() {
    if (this.service.role() == "USER") {
      this.route.navigate(['user-cafedetails'])
    }
    if (this.service.role() == "ADMIN") {
      this.route.navigate(['admin-cafedetails'])
    }
  }

  yourOrders() {
    this.route.navigate(['your-orders']);
  }



  goYourOrders() {
    this.route.navigate(['your-orders']);
  }

  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk() {
    this.route.navigate(['user-helpdesk']);
  }


}
