import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
  }

  mapAdd() {
    this.route.navigate(['menu-edit']);
  }

  mapSearch() {
    this.route.navigate(['menu-search']);
  }

  mapList() {
    this.route.navigate(['menu-list']);
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


}
