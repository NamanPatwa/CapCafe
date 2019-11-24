import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../../../model/cafemenu.model';
import { MenuServicesService } from '../../../Services/menu-services/menu-services.service';
import { Router } from '@angular/router';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  //search:boolean =false;
  items: CafeMenu[];
  constructor(private cafeService: CafedetailsService, private service: MenuServicesService, private route: Router) { }

  ngOnInit() {
    this.service.listMenu().subscribe(data => this.items = data);
  }

  delete(item: CafeMenu) {
    var ans = confirm("Are you sure you want to delete?")
    if (ans) {
      this.service.deleteMenuItem(item.itemId).subscribe(data => this.items = this.items.filter(u => u !== item)) //Delete from service
    }
  }

  goEdit() {
    this.route.navigate(['menu-edit']);
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
    if (this.cafeService.role() == "USER") {
      this.route.navigate(['user-cafedetails'])
    }
    if (this.cafeService.role() == "ADMIN") {
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
