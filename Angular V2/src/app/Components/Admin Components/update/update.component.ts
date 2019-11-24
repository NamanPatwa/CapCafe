import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../../../model/cafedetails.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  cafe: CafeDetails;

  constructor(private service: CafedetailsService, private route: Router) {
    this.cafe = new CafeDetails()
  }

  ngOnInit() {
  }

  update() {
    this.service.saveCafe(this.cafe).subscribe(data => this.cafe = data);
    this.cafe = new CafeDetails();
    this.route.navigate(['list']);
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
      this.route.navigate(['admin-home'])
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
