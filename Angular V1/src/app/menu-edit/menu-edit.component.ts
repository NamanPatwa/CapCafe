import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CafeMenu } from '../model/cafemenu.model';
import { MenuServicesService } from '../menu-services/menu-services.service';
import { Router } from '@angular/router';
import { CafedetailsService } from '../cafedetails/cafedetails.service';

@Component({
  selector: 'app-menu-edit',
  templateUrl: './menu-edit.component.html',
  styleUrls: ['./menu-edit.component.css']
})
export class MenuEditComponent implements OnInit {

  @ViewChild('addForm') menuAddForm:NgForm;
  menuItem: CafeMenu;
  itemId: number;

  constructor(private cafeService:CafedetailsService, private service:MenuServicesService, private route:Router) { 
    this.menuItem = new CafeMenu();
  }

  ngOnInit() {
  }

  add(form:NgForm) {
    this.service.saveMenuItem(this.menuItem).subscribe(data => this.menuItem=data);
    this.menuItem=new CafeMenu();
    form.reset();
    //this.route.navigate(['search']);
  }

  onClear() {
    this.menuAddForm.reset();
    //this.editMode = false;
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
    if(this.cafeService.role()=="USER"){
      this.route.navigate(['user-cafedetails'])
    }
    if(this.cafeService.role()=="ADMIN"){
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

  getall(){
    this.route.navigate(['getall']);  
  }


}
