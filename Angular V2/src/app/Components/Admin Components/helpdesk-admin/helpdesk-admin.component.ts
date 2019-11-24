import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../../model/Ticket';
import { HelpdeskAdminService } from '../../../Services/helpdesk-service/helpdesk-admin.service';
import { Router } from '@angular/router';
import { CafedetailsService } from '../../../Services/cafedetails/cafedetails.service';

@Component({
  selector: 'app-helpdesk-admin',
  templateUrl: './helpdesk-admin.component.html',
  styleUrls: ['./helpdesk-admin.component.css']
})
export class HelpdeskAdminComponent implements OnInit {

  resolved: number;
  unresolved: number;
  unresolvedTickets: Ticket[];
  getUnresolved: boolean = true;
  tickets: Ticket[];
  location: string;
  selectedTicket: number;
  isVisible: boolean = true;
  colour: string = "red";
  value: string = "Fail";
  ticketNumber: number;


  constructor(private cafeService: CafedetailsService, private service: HelpdeskAdminService, private router: Router) { }

  ngOnInit() {
    this.service.showResolvedCount().subscribe(data => this.resolved = data);
    this.service.showUnresolvedCount().subscribe(data => this.unresolved = data);
    this.listAllTickets();
  }

  listAllTickets() {
    this.service.listAllTickets().subscribe(data => this.tickets = data);
  }

  listResolvedTickets() {
    this.service.listResolvedTickets().subscribe(data => this.tickets = data);
  }

  listUnresolvedTickets() {
    this.service.listUnresolvedTickets().subscribe(data => this.tickets = data);
  }

  listByLocation() {
    console.log(this.location);
    this.service.listTicketByLocation(this.location).subscribe(data => this.tickets = data);
  }

  latestFirst() {
    this.tickets = this.service.latestFirst(this.tickets);
  }

  resolvedFirst() {
    this.tickets = this.service.resolvedFirst(this.tickets);
  }

  unresolvedFirst() {
    this.tickets = this.service.unresolvedFirst(this.tickets);
  }

  onSelect(t: Ticket) {
    this.selectedTicket = t.ticketNumber;
    this.router.navigate(['admin-chat', this.selectedTicket]);
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
      this.router.navigate(['user-cafedetails'])
    }
    if (this.cafeService.role() == "ADMIN") {
      this.router.navigate(['admin-home'])
    }
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



}
