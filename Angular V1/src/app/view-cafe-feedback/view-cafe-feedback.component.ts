import { Component, OnInit } from '@angular/core';
import { CafeDetails } from '../model/cafedetails.model';
import { CafedetailsService } from '../cafedetails/cafedetails.service';
import { Feedback } from '../model/Feedback';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-cafe-feedback',
  templateUrl: './view-cafe-feedback.component.html',
  styleUrls: ['./view-cafe-feedback.component.css']
})
export class ViewCafeFeedbackComponent implements OnInit {
  cafe : CafeDetails;
  cafeReview : String[];
  avgRating : number; 
  constructor(private service : CafedetailsService, private route : Router) { }

  ngOnInit() {  
    this.cafe = this.service.userCafe;
    console.log(this.cafe);
    this.getCafeReview();
    this.viewCafeAvgRating();
  }

  getCafeReview(){
    this.service.listCafeReviewById(this.cafe.cafeId).subscribe(data => {this.cafeReview = data;
    console.log(this.cafeReview);
    })
  }

  addReview(){
    this.service.userCafe = this.cafe;
    this.route.navigate(['add-cafe-feedback']);
  }

  viewCafeAvgRating(){
    this.service.searchCafeAverageRating(this.cafe.cafeId).subscribe(data =>{this.avgRating = data;
    console.log(this.avgRating);
    })
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

  yourOrders(){
    this.route.navigate(['your-orders']);
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
