import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  employee: Employee;

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
    this.profile();
  }

  profile() {
    console.log("hello");
    this.employee = this.service.profile();
    console.log(this.employee);
  }

  navigateResetPassword() {
    this.route.navigate(['resetpassword']);
  }

  logout() {
    sessionStorage.removeItem('role');
    this.route.navigate(['login']);
  }

  profileView() {
    this.profile();
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
