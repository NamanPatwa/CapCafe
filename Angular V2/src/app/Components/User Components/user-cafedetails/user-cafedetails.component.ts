import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-user-cafedetails',
  templateUrl: './user-cafedetails.component.html',
  styleUrls: ['./user-cafedetails.component.css']
})
export class UserCafedetailsComponent implements OnInit {

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
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

  yourOrders() {
    this.route.navigate(['your-orders']);
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

  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk() {
    this.route.navigate(['user-helpdesk']);
  }

}
