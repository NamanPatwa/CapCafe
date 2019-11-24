package com.cg.service;


import java.util.InputMismatchException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.Order;
import com.cg.dto.RequestResponse;
import com.cg.dto.Ticket;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;
import com.cg.repo.OrderRepo;
import com.cg.repo.TicketRepo;


@Service
@Transactional(rollbackFor = {OrderNotFoundException.class, TicketNotFoundException.class})
public class HelpdeskServiceImpl implements HelpdeskService {

	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private RequestResponseService requestResponseService;
	
	@Autowired
	private OrderService orderSerice;
	
	@Override
	public Ticket raiseTicket(int orderId, String message) throws OrderNotFoundException {
		if(message == null) {
			throw new InputMismatchException("Message cannot be empty");
		}
		Order order;
		try {
			order = orderSerice.getById(orderId);
		} catch (Exception e) {
			throw new OrderNotFoundException("Order with Order ID: " + orderId + " not found");
		}
		
		Ticket ticket = ticketRepo.getByOrder(order);	
			
		// check if ticket exists with that id
		// if does not exist then create a new one 
			
		if(ticket == null) {
			RequestResponse requestResponse = new RequestResponse();
			// setting ticket values
			ticket = new Ticket();
			ticket.setOrder(order);
			ticket.setLocation(order.getLocation());
			ticket = ticketRepo.save(ticket);		//saving helpdesk to database
			
			// creating request response object
			requestResponse.setMessage(message);	
			requestResponse.setQuery(ticket);
			requestResponse.setType("Request");
			requestResponseService.addRequestResponse(requestResponse); // adding to database
			Ticket t = ticketRepo.getByOrder(order);
			return t;
		} else {
			// if already exists then only add request-response
			RequestResponse requestResponse = new RequestResponse();
			requestResponse.setMessage(message);
			requestResponse.setQuery(ticket);
			requestResponse.setType("Request");
			requestResponseService.addRequestResponse(requestResponse);
			return ticket;
		}
	}


	@Override
	public Ticket getByTicketNumber(int id) throws TicketNotFoundException {
		Ticket ticket;
		try {
			ticket = ticketRepo.findById(id).get();
			return ticket;
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket with given ID: " + id + " not found");
		}
	}
	
	@Override
	public List<Ticket> listAllTickets() {
		return ticketRepo.findAll();
	}
	
	@Override
	public List<Ticket> listUnresolvedTickets() {
		return ticketRepo.listUnresolvedTickets();
	}

	@Override
	public List<Ticket> listResolvedTickets() {
		return ticketRepo.listResolvedTickets();
	}
	
	@Override
	public int markAsResolved(int ticketNumber) throws TicketNotFoundException {
		try {
			ticketRepo.findById(ticketNumber).get();
			return ticketRepo.markAsResolved(ticketNumber);
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket with ID: " + ticketNumber + " not found");
		}
	}
	
	@Override
	public Ticket sendResponse(int ticketNumber, String message) throws TicketNotFoundException {
		if(message == null) {
			throw new InputMismatchException("Message cannot be null");
		}
		try {
			Ticket ticket = ticketRepo.findById(ticketNumber).get();
			RequestResponse requestResponse = new RequestResponse();
			requestResponse.setMessage(message);
			requestResponse.setQuery(ticket);
			requestResponse.setType("Response");
			requestResponseService.addRequestResponse(requestResponse);
			return ticket;
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket with ID: " + ticketNumber + " not found");
		}
	}
	
	@Override
	public Ticket getByOrderId(int orderId) throws TicketNotFoundException, OrderNotFoundException {
		Order order;
		try {
			order = orderSerice.getById(orderId);
		} catch (Exception e) {
			throw new OrderNotFoundException("Order not found with ID: " + orderId );
		}
		
		try {
			Ticket ticket = ticketRepo.getByOrder(order);
			return ticket;
		} catch (Exception e) {
			throw new TicketNotFoundException("Ticket Not Found");
		}
	}
	
	
	@Override
	public int countResolvedQueries() {
		return ticketRepo.countResolvedQueries();
	}

	@Override
	public int countUnresolvedQueries() {
		return ticketRepo.countUnresolvedQueries();
	}
	
	@Override
	public List<Ticket> getByLocation(String location) throws TicketNotFoundException {
		List<Ticket> tickets =  ticketRepo.getByLocation(location);
		if(tickets.size() == 0) {
			throw new TicketNotFoundException("Ticket with given location not found");
		}
		return tickets;
	}
	
	///////////////Order Related /////////////
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
	@Override
	public Order addNewOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getById(int orderId) {
		return orderRepo.findById(orderId).get();
	}
	//////////////////////////////////////////


	

}
