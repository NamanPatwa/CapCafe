import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ticket } from '../../../model/Ticket';
import { HelpdeskAdminService } from '../../../Services/helpdesk-service/helpdesk-admin.service';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-admin-chat',
  templateUrl: './admin-chat.component.html',
  styleUrls: ['./admin-chat.component.css']
})
export class AdminChatComponent implements OnInit {

  sub;
  ticketNumber: number = 0;
  ticket: Ticket;
  message: string;

  constructor(private route: ActivatedRoute, private cafeService: CafedetailsService, private service: HelpdeskAdminService, private router: Router) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.ticketNumber = params['id'];
    });
    console.log(this.ticketNumber);
    this.getTicketDetails();
    this.sortMessagesById();
  }

  getTicketDetails() {
    this.service.getTicketByNumber(this.ticketNumber).subscribe(data => {
      this.ticket = data
      this.sortMessagesById();
    });

  }

  giveResponseByTicketNumber() {
    this.service.addResponseByTicketNumber(this.ticketNumber, this.message).subscribe(data => {
      this.ticket = data;
      this.getTicketDetails();

    });
    this.message = "";
  }

  sortMessagesById() {
    this.ticket = this.service.sortMessagesById(this.ticket);
  }

  goCafeManagement() {
    this.router.navigate(['admin-cafedetails']);
  }

  goMenuManagement() {
    this.router.navigate(['admin-menu']);
  }

  goHelpdesk() {
    this.router.navigate(['admin-helpdesk']);
  }

  goOrderManagement() {
    this.router.navigate(['admin-list-orders']);
  }

  getall() {
    this.router.navigate(['getall']);
  }

  navigateResetPassword() {
    this.router.navigate(['resetpassword']);
  }

  logout() {
    sessionStorage.removeItem('role');
    this.router.navigate(['login']);
  }

  profile() {
    this.router.navigate(['profile']);
  }

  home() {
    if (this.cafeService.role() == "USER") {
      this.router.navigate(['user-cafedetails']);
    }
    if (this.cafeService.role() == "ADMIN") {
      this.router.navigate(['admin-home']);
    }
  }

}
