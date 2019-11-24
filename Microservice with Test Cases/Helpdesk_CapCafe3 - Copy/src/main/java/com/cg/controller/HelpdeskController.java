package com.cg.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Ticket;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;
import com.cg.service.HelpdeskService;
import com.cg.service.OrderServiceImpl;

/**
 * @author Bhushan Sonawane
 * @version 1.0
 * This is controller class for helpdesk service
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/helpdesk")
public class HelpdeskController {
	
	@Autowired
	private HelpdeskService service;
	
	static Logger myLogger =  Logger.getLogger(OrderServiceImpl.class);
	
	/**
	 * To raise a ticket based on the Order ID. Used by Customer
	 * @param id
	 * @param msg
	 * @return Ticket
	 * @throws OrderNotFoundException
	 */
	@PostMapping(value = "/ticket/add/{id}/{msg}", produces = "application/json")
	public Ticket raiseTicket(@PathVariable("id") int id, @PathVariable("msg") String msg) throws OrderNotFoundException {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING to raise ticket");
		return service.raiseTicket(id, msg);
	}
	
	
	/**
	 * To give Response to the raised ticket by the Admin of system
	 * @param ticketNumber
	 * @param msg
	 * @return Ticket(with added response)
	 * @throws TicketNotFoundException
	 */
	@PostMapping(value = "/ticket/response/{ticketNumber}/{msg}", produces = "application/json")
	public Ticket giveResponse(@PathVariable("ticketNumber") int ticketNumber, @PathVariable("msg") String msg) throws TicketNotFoundException {
		myLogger.info("================================================");
		myLogger.info("POST MAPPING to give response");
		return service.sendResponse(ticketNumber, msg);
	}
	
	/**
	 * Will return all the tickets (resolved/unresolved) to admin
	 * @return all tickets raised
	 */
	@GetMapping(value = "/ticket/list", produces = "application/json")
	public List<Ticket> allTickets(){
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get all ticket");
		return service.listAllTickets();
	}
	
	/**
	 * To get ticket by particular ticket ID. For admin
	 * @param id
	 * @return Ticket by input id
	 * @throws TicketNotFoundException
	 */
	@GetMapping(value = "ticket/id/{id}", produces = "application/json")
	public Ticket getById(@PathVariable("id") int id) throws TicketNotFoundException {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get by id");
		return service.getByTicketNumber(id);
	}
	
	/**
	 * Will return all the resolved tickets
	 * @return List of Tickets
	 */
	@GetMapping(value = "/ticket/list/resolved", produces = "application/json")
	public List<Ticket> getResolvedTickets(){
		return service.listResolvedTickets();
	}
	
	/**
	 * Will return list of unresolved ticekts
	 * @return List of Tickets
	 */
	@GetMapping(value = "/ticket/count/resolved")
	public int countResolvedTickets() {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to resolve ticket");
		return service.countResolvedQueries();
	}
	
	/**
	 * To get count of resolved tickets till date
	 * @return integer 
	 */
	@GetMapping(value = "/ticket/count/unresolved")
	public int countUnresolvedTickets() {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to count unresolved ticket");
		return service.countUnresolvedQueries();
	}
	
	/**
	 * To get all unresolved tickets
	 * @return List of Tickets
	 */
	@GetMapping(value = "/ticket/list/unresolved", produces = "application/json")
	public List<Ticket> getUnresolvedTickets(){
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get unresolved ticket");
		return service.listUnresolvedTickets();
	}
	
	/**
	 * To get ticket by particular order ID
	 * @param orderId
	 * @return Ticket
	 * @throws TicketNotFoundException
	 * @throws OrderNotFoundException
	 */
	@GetMapping(value = "/ticket/orderid/{orderId}", produces = "application/json")
	public Ticket getTicketByOrderId(@PathVariable("orderId") int orderId) throws TicketNotFoundException, OrderNotFoundException {
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get ticket by order id");
		return service.getByOrderId(orderId);
	}
	
	/**
	 * To get List of tickets as per locations
	 * @param location
	 * @return List of Tickets
	 * @throws TicketNotFoundException
	 */
	@GetMapping(value = "/ticket/list/location/{location}", produces = "application/json")
	public List<Ticket> getByLocation(@PathVariable("location") String location) throws TicketNotFoundException{
		myLogger.info("================================================");
		myLogger.info("GET MAPPING to get by location");
		return service.getByLocation(location);
	}
	
	
	/**
	 * To mark a raised ticket as resolved. Used only by user
	 * @param ticketNumber
	 * @return int 
	 * @throws TicketNotFoundException
	 */
	@PutMapping(value = "/ticket/resolve/{ticketNumber}")
	public int markAsResolved(@PathVariable("ticketNumber") int ticketNumber) throws TicketNotFoundException {
		myLogger.info("================================================");
		myLogger.info("PUT MAPPING to mark as resolved");
		return service.markAsResolved(ticketNumber);
	}
	
	
	
}
