import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderModel } from '../../../model/order';
import { Ticket } from '../../../model/Ticket';
import { HelpdeskUserService } from '../../../Services/helpdesk-service/helpdesk-user.service';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-user-chat',
  templateUrl: './user-chat.component.html',
  styleUrls: ['./user-chat.component.css']
})
export class UserChatComponent implements OnInit {

  sub;
  orderId: number;
  order: OrderModel;
  ticket: Ticket;
  ticketExist: boolean = false;
  message: string;
  resolved: number;

  constructor(private route1: Router, private cafeService: CafedetailsService, private route: ActivatedRoute, private service: HelpdeskUserService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.orderId = params['id'];
      this.getOrderById();
      console.log(this.order);
    });
    this.getOrderById();
  }

  getOrderById() {
    this.service.getOrderById(this.orderId).subscribe(data => {
      this.order = data;
      this.getTicketByOrderId();
      console.log(this.order);
    });
  }

  getTicketByOrderId() {
    this.service.getTicketByOrderId(this.orderId).subscribe(data => {
      this.ticket = data;
      this.sortMessagesById()
    });
  }

  giveRequestByOrderId() {
    this.service.addResponseByOrderId(this.orderId, this.message).subscribe(data => {
      this.ticket = data;
      this.getTicketByOrderId();
      this.message = "";
    });
  }

  markAsResolved() {
    this.service.markAsResolved(this.ticket.ticketNumber).subscribe(data => {
      this.resolved = data;
      this.getTicketByOrderId();
    });
  }

  sortMessagesById() {
    this.ticket = this.service.sortMessagesById(this.ticket);
  }

  navigateResetPassword() {
    this.route1.navigate(['resetpassword']);
  }

  logout() {
    sessionStorage.removeItem('role');
    this.route1.navigate(['login']);
  }

  profile() {
    this.route1.navigate(['profile']);
  }

  home() {
    if (this.cafeService.role() == "USER") {
      this.route1.navigate(['user-cafedetails'])
    }
    if (this.cafeService.role() == "ADMIN") {
      this.route1.navigate(['admin-cafedetails'])
    }
  }

  goYourOrders() {
    this.route1.navigate(['your-orders']);
  }

  mapList() {
    this.route1.navigate(['user-list']);
  }

  yourOrders() {
    this.route1.navigate(['your-orders']);
  }




  goHelpdesk() {
    this.route1.navigate(['user-helpdesk']);
  }


}
