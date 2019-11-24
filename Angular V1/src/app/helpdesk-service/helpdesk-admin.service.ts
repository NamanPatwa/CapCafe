import { Injectable } from '@angular/core';
import { Ticket } from '../model/Ticket';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HelpdeskAdminService {

  constructor(public http : HttpClient) { }

  showResolvedCount(){
    return this.http.get<number>("http://localhost:9990/cafefront/ticket/count/resolved");
  }

  showUnresolvedCount(){
    return this.http.get<number>("http://localhost:9990/cafefront/ticket/count/unresolved");
  }

  listAllTickets(){
    return this.http.get<Ticket[]>("http://localhost:9990/cafefront/ticket/list");
  }

  listResolvedTickets(){
    return this.http.get<Ticket[]>("http://localhost:9990/cafefront/ticket/list/resolved");
  }

  listUnresolvedTickets(){
    return this.http.get<Ticket[]>("http://localhost:9990/cafefront/ticket/list/unresolved");
  }

  listTicketByLocation(location : string){
    return this.http.get<Ticket[]>("http://localhost:9990/cafefront/ticket/list/location/"+location);
  }

  getTicketByNumber(ticketNumber : number){
    return this.http.get<Ticket>("http://localhost:9990/cafefront/ticket/id/"+ticketNumber);
  }

  addResponseByTicketNumber(ticketNumber : number,response : string){
    return this.http.post<Ticket>("http://localhost:9990/cafefront/ticket/response/"+ticketNumber+"/"+response, response);
  }

  resolvedFirst(tickets : Ticket[]){
    tickets.sort((a, b) => a.status > b.status ? 1 : ((a.status < b.status) ? -1 : 0));
    console.log(tickets);
    return tickets;
  }

  unresolvedFirst(tickets : Ticket[]){
    tickets.sort((a, b) => a.status < b.status ? 1 : ((a.status > b.status) ? -1 : 0));
    console.log(tickets);
    return tickets;
  }

  latestFirst(tickets : Ticket[]){
    tickets.sort((a, b) => a.ticketNumber < b.ticketNumber ? 1 : ((a.ticketNumber > b.ticketNumber) ? -1 : 0));
    console.log(tickets);
    return tickets;
  }

  sortMessagesById(ticket : Ticket){
    ticket.messages.sort((a,b) => a.messageId > b.messageId ? 1 : ((a.messageId < b.messageId) ? -1 : 0 ));
    return ticket;
  }
}
