import { Component, OnInit } from '@angular/core';
import { OrderDetailModel } from '../model/orderdetails';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-view-orderdetails',
  templateUrl: './admin-view-orderdetails.component.html',
  styleUrls: ['./admin-view-orderdetails.component.css']
})
export class AdminViewOrderdetailsComponent implements OnInit {

  sub;
  orderId : number;
  collection:OrderDetailModel[];
  constructor(private service:CafedetailsService,private route:ActivatedRoute, private route1 :Router) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
    this.orderId = params['id'];
    });
    console.log(this.orderId);
    this.service.viewOrderDetails(this.orderId).subscribe(data => this.collection=data);
    console.log(this.collection);
  }

  goHome(){
    this.route1.navigate(['admin-home']);
  }

  navigateResetPassword(){
    this.route1.navigate(['resetpassword']); 
  }

  logout(){
    sessionStorage.removeItem('role');
    this.route1.navigate(['login']); 
  }

  profile(){
    this.route1.navigate(['profile']); 
  }

  home(){
    if(this.service.role()=="USER"){
      this.route1.navigate(['user-cafedetails'])
    }
    if(this.service.role()=="ADMIN"){
      this.route1.navigate(['admin-home'])
    }
  }

  goCafeManagement() {
    this.route1.navigate(['admin-cafedetails']);
  }

  goMenuManagement() {
    this.route1.navigate(['admin-menu']);
  }

  goHelpdesk() {
    this.route1.navigate(['admin-helpdesk']);
  }

  goOrderManagement() {
    this.route1.navigate(['admin-list-orders']);
  }

  getall(){
    this.route1.navigate(['getall']);  
  }

}
