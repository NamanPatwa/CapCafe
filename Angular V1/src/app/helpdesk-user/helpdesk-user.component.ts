import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../model/order';
import { HelpdeskUserService } from '../helpdesk-service/helpdesk-user.service';
import { Router } from '@angular/router';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Employee } from '../model/employee.model';

@Component({
  selector: 'app-helpdesk-user',
  templateUrl: './helpdesk-user.component.html',
  styleUrls: ['./helpdesk-user.component.css']
})
export class HelpdeskUserComponent implements OnInit {

  orders : OrderModel[];
  selectedOrder : number;
  location : string;
  user : Employee;

  constructor(private cafeService: CafedetailsService, private service : HelpdeskUserService, private router : Router) { }

  ngOnInit() {
    this.user = this.cafeService.employee;
    console.log(this.user);
    this.listAllOrders();
  }

  getOrderByLocation(){
    this.service.getOrderByLocation(this.location).subscribe(data => this.orders = data);
    if(this.orders.length == 0){ 
      alert("No Order with given location found!");
    }
  }

  onSelect(o : OrderModel){
    this.selectedOrder = o.orderId;
    this.router.navigate(['user-chat',this.selectedOrder]);
  }

  latestFirst(){
    this.orders = this.service.latestFirst(this.orders);
  }

  listAllOrders(){
    this.cafeService.getOrdersByEmployeeId(this.user.employeeId).subscribe(data=>{this.orders = data;
    console.log(this.orders);
    })
  }

  navigateResetPassword(){
    this.router.navigate(['resetpassword']); 
  }

  logout(){
    sessionStorage.removeItem('role');
    this.router.navigate(['login']); 
  }

  profile(){
    this.router.navigate(['profile']); 
  }

  home(){
    if(this.cafeService.role()=="USER"){
      this.router.navigate(['user-cafedetails'])
    }
    if(this.cafeService.role()=="ADMIN"){
      this.router.navigate(['admin-cafedetails'])
    }
  }

  yourOrders(){
    this.router.navigate(['your-orders']);
  }



  mapList() {
    this.router.navigate(['user-list']);
  }

  goHelpdesk(){
    this.router.navigate(['user-helpdesk']);
  }

}
