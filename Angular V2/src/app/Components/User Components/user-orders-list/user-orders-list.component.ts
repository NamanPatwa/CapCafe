import { Component, OnInit } from '@angular/core';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';
import { Employee } from '../../../model/employee.model';
import { OrderModel } from '../../../model/order';

@Component({
  selector: 'app-user-orders-list',
  templateUrl: './user-orders-list.component.html',
  styleUrls: ['./user-orders-list.component.css']
})
export class UserOrdersListComponent implements OnInit {

  user: Employee;
  orders: OrderModel[];

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
    this.user = this.service.employee;
    this.getOrdersById();
  }


  getOrdersById() {
    this.service.getOrdersByEmployeeId(this.user.employeeId).subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    })
  }

  getSummary(o: OrderModel) {
    this.service.selectedOrder = o;
    this.route.navigate(['user-order-summary']);
  }

  goHome() {
    this.route.navigate(['user-cafedetails'])
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

  goYourOrders() {
    this.route.navigate(['your-orders']);
  }

  yourOrders() {
    this.route.navigate(['your-orders']);
  }




  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk() {
    this.route.navigate(['user-helpdesk']);
  }
}
