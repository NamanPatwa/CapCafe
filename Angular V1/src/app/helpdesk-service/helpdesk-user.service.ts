import { Injectable } from '@angular/core';
import { Ticket } from '../model/Ticket';
import { OrderModel } from '../model/order';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HelpdeskUserService {

  orders : OrderModel[];
  
  constructor(public http : HttpClient) { }

  listAllOrders(){
    return this.http.get<OrderModel[]>("http://localhost:9990/cafefront/ticketorder/all")
  }

  latestFirst(orders : OrderModel[]){
    orders.sort((a, b) => a.orderId < b.orderId ? 1 : ((a.orderId > b.orderId) ? -1 : 0));
    console.log(orders);
    return orders;
  }

  getOrderByLocation(location : string){
    return this.http.get<OrderModel[]>("http://localhost:9990/cafefront/ticketorder/location/"+location);
  }

  getOrderById(id : number){
    return this.http.get<OrderModel>("http://localhost:9990/cafefront/ticketorder/id/" + id);
  }

  getTicketByOrderId(orderId : number){
    return this.http.get<Ticket>("http://localhost:9990/cafefront/ticket/orderid/" + orderId);
  }

  addResponseByOrderId(orderId:number, message:string){
    return this.http.post<Ticket>("http://localhost:9990/cafefront/ticket/add/" + orderId + "/" +message, message);
  }
  
  markAsResolved(ticketNumber : number){
    return this.http.put<number>("http://localhost:9990/cafefront/ticket/resolve/"+ticketNumber, ticketNumber);
  }

  sortMessagesById(ticket : Ticket){
    ticket.messages.sort((a,b) => a.messageId > b.messageId ? 1 : ((a.messageId < b.messageId) ? -1 : 0 ));
    return ticket;
  }
}
