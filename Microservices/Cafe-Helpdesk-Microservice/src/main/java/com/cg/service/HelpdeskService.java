package com.cg.service;

import java.util.List;

import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;
import com.cg.dto.Order;
import com.cg.dto.Ticket;

public interface HelpdeskService {
	
	///////////Order Related//////////////
	
	List<Order> getAllOrders();
	
	Order addNewOrder(Order order);
	
	Order getById(int orderId);
	
	/////////////////////////////////////
	
	Ticket raiseTicket(int orderId, String message) throws OrderNotFoundException;
	
	Ticket sendResponse(int ticketNumber, String message) throws TicketNotFoundException;
	
	Ticket getByTicketNumber(int id) throws TicketNotFoundException;
	
	List<Ticket> listAllTickets();
	
	List<Ticket> listUnresolvedTickets();
	
	List<Ticket> listResolvedTickets();
	
	int markAsResolved(int ticketNumber) throws TicketNotFoundException;
	
	Ticket getByOrderId(int orderId) throws TicketNotFoundException, OrderNotFoundException;
	
	int countResolvedQueries();
	
	int countUnresolvedQueries();
	
	List<Ticket> getByLocation(String location) throws TicketNotFoundException;
	
}
