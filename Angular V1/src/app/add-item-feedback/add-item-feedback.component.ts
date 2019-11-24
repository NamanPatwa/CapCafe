import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { Router } from '@angular/router';
import { CafeMenu } from '../model/cafemenu.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Employee } from '../model/employee.model';
import { Feedback } from '../model/Feedback';

@Component({
  selector: 'app-add-item-feedback',
  templateUrl: './add-item-feedback.component.html',
  styleUrls: ['./add-item-feedback.component.css']
})
export class AddItemFeedbackComponent implements OnInit {

  item : CafeMenu;
  user :Employee;
  userId: string;
  cafeRating : number;
  cafeReview : String;
  type : String = "item"; 
  feedback : Feedback;

  constructor(private service : CafedetailsService, private route : Router) { }

  ngOnInit() {
    this.item = this.service.itemfororder;
    console.log(this.item);
    this.user = this.service.employee;
    console.log(this.user);
    this.userId = this.user.employeeId;
  }

  yourOrders(){
    this.route.navigate(['your-orders']);
  }




  addItemFeedback(){
    this.service.saveItemRating(this.userId, this.item.itemName, this.type, this.cafeRating).subscribe(data=> {this.feedback = data;
    console.log(this.feedback);
  });
    this.service.saveItemReview(this.userId, this.item.itemName, this.type, this.cafeReview).subscribe(data => { this.feedback = data;
    console.log(this.feedback);
    });

    this.route.navigate(['view-item-feedback'])
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
      this.route.navigate(['admin-cafedetails']);
    }
  }

  goYourOrders(){
    this.route.navigate(['your-orders']);
  }

  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk(){
    this.route.navigate(['user-helpdesk']);
  }
  
}
