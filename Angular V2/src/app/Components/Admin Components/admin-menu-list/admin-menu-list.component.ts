import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../../../model/cafemenu.model';
import { CafeDetails } from '../../../model/cafedetails.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu-list',
  templateUrl: './admin-menu-list.component.html',
  styleUrls: ['./admin-menu-list.component.css']
})
export class AdminMenuListComponent implements OnInit {

  cafe: CafeDetails;

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
    this.cafe = this.service.selectedCafe;
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

  getall() {
    this.route.navigate(['getall']);
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
      this.route.navigate(['user-cafedetails']);
    }
    if (this.service.role() == "ADMIN") {
      this.route.navigate(['admin-home']);
    }
  }

}
