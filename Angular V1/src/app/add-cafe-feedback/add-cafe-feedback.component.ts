import { Component, OnInit } from '@angular/core';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { CafeDetails } from '../model/cafedetails.model';
import { Feedback } from '../model/Feedback';
import { Employee } from '../model/employee.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-cafe-feedback',
  templateUrl: './add-cafe-feedback.component.html',
  styleUrls: ['./add-cafe-feedback.component.css']
})
export class AddCafeFeedbackComponent implements OnInit {

  cafe : CafeDetails;
  userId : string;
  cafeRating : number;
  cafeReview : string;
  review : Feedback;
  type : string ="cafe";
  user : Employee;

  constructor(private service : CafedetailsService, private route : Router) { }

  ngOnInit() {
    this.cafe = this.service.userCafe;
    console.log(this.cafe);
    this.user = this.service.employee;
    this.userId = this.user.employeeId;
    console.log(this.userId);
  }

  addCafeFeedback(){
    this.service.saveCafeReview(this.userId, this.cafe.cafeName, this.type ,this.cafeReview).subscribe(data => { this.review = data;
    console.log(this.review);
    console.log(this.cafeReview); });
    this.service.saveCafeRating(this.userId, this.cafe.cafeName, this.type, this.cafeRating).subscribe(data => { this.review = data;
    console.log(this.review);
    console.log(this.cafeRating);
    });
    this.route.navigate(['view-feedback']);
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
      this.route.navigate(['user-cafedetails'])
    }
    if(this.service.role()=="ADMIN"){
      this.route.navigate(['admin-cafedetails'])
    }
  }

  goYourOrders(){
    this.route.navigate(['your-orders']);
  }

  yourOrders(){
    this.route.navigate(['your-orders']);
  }




  mapList() {
    this.route.navigate(['user-list']);
  }

  goHelpdesk(){
    this.route.navigate(['user-helpdesk']);
  }

}
