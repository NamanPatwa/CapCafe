import { Component, OnInit } from '@angular/core';
import { CafeMenu } from '../../../model/cafemenu.model';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';
import { Feedback } from '../../../model/Feedback';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-item-feedback',
  templateUrl: './view-item-feedback.component.html',
  styleUrls: ['./view-item-feedback.component.css']
})
export class ViewItemFeedbackComponent implements OnInit {

  item: CafeMenu;
  feedback: Feedback[];
  avg: number;

  constructor(private service: CafedetailsService, private route: Router) { }

  ngOnInit() {
    this.item = this.service.itemfororder;
    console.log(this.item);
    this.getItemFeedback();
    this.getAvgRating();
  }

  getItemFeedback() {
    this.service.listItemReviewById(this.item.itemId).subscribe(data => {
      this.feedback = data;
      console.log(this.feedback);
    })
  }

  yourOrders() {
    this.route.navigate(['your-orders']);
  }




  getAvgRating() {
    this.service.searchItemAverageRating(this.item.itemId).subscribe(data => {
      this.avg = data;
      console.log(this.avg);
    })
  }

  addReview() {
    this.service.itemfororder = this.item;
    this.route.navigate(['add-item-feedback']);
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
      this.route.navigate(['admin-cafedetails']);
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
