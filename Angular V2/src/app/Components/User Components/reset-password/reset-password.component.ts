import { Component, OnInit } from '@angular/core';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  empId: string;
  prevpass: string;
  newpass: string;
  result: boolean;

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
  }

  resetPassword() {
    this.service.resetPassword(this.empId, this.prevpass, this.newpass).subscribe(data => {
      this.result = data;
      if (this.result == true) {
        alert("password successfully changed");
      } else {
        alert("password not changed");
      }
    });
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
