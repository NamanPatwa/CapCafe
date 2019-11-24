package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Ticket;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;
import com.cg.service.HelpdeskService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/helpdesk")
public class HelpdeskController {
	
	@Autowired
	private HelpdeskService service;
	
	@PostMapping(value = "/ticket/add/{id}/{msg}", produces = "application/json")
	public Ticket raiseTicket(@PathVariable("id") int id, @PathVariable("msg") String msg) throws OrderNotFoundException {
		return service.raiseTicket(id, msg);
	}
	
	@PostMapping(value = "/ticket/response/{ticketNumber}/{msg}", produces = "application/json")
	public Ticket giveResponse(@PathVariable("ticketNumber") int ticketNumber, @PathVariable("msg") String msg) throws TicketNotFoundException {
		return service.sendResponse(ticketNumber, msg);
	}
	
	@GetMapping(value = "/ticket/list", produces = "application/json")
	public List<Ticket> allTickets(){
		return service.listAllTickets();
	}
	
	@GetMapping(value = "ticket/id/{id}", produces = "application/json")
	public Ticket getById(@PathVariable("id") int id) throws TicketNotFoundException {
		return service.getByTicketNumber(id);
	}
	
	@GetMapping(value = "/ticket/list/resolved", produces = "application/json")
	public List<Ticket> getResolvedTickets(){
		return service.listResolvedTickets();
	}
	
	@GetMapping(value = "/ticket/count/resolved")
	public int countResolvedTickets() {
		return service.countResolvedQueries();
	}
	
	@GetMapping(value = "/ticket/count/unresolved")
	public int countUnresolvedTickets() {
		return service.countUnresolvedQueries();
	}
	
	@GetMapping(value = "/ticket/list/unresolved", produces = "application/json")
	public List<Ticket> getUnresolvedTickets(){
		return service.listUnresolvedTickets();
	}
	
	@GetMapping(value = "/ticket/orderid/{orderId}", produces = "application/json")
	public Ticket getTicketByOrderId(@PathVariable("orderId") int orderId) throws TicketNotFoundException, OrderNotFoundException {
		return service.getByOrderId(orderId);
	}
	
	@GetMapping(value = "/ticket/list/location/{location}", produces = "application/json")
	public List<Ticket> getByLocation(@PathVariable("location") String location) throws TicketNotFoundException{
		return service.getByLocation(location);
	}
	
	@PutMapping(value = "/ticket/resolve/{ticketNumber}")
	public int markAsResolved(@PathVariable("ticketNumber") int ticketNumber) throws TicketNotFoundException {
		return service.markAsResolved(ticketNumber);
	}
	
	
	
}
