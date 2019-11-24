import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-all',
  templateUrl: './get-all.component.html',
  styleUrls: ['./get-all.component.css']
})
export class GetAllComponent implements OnInit {

  employees:Employee[];

  constructor(private service:CafedetailsService,private route:Router) { }

  ngOnInit() {
    this.service.getAll().subscribe(data=>this.employees=data);
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
