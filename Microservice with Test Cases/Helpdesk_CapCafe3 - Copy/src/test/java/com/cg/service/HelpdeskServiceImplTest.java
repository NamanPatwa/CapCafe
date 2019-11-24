package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Orders;
import com.cg.entity.Ticket;
import com.cg.exception.OrderNotFoundException;
import com.cg.exception.TicketNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelpdeskServiceImplTest {

	@Autowired
	private HelpdeskService service;
	
	private Orders order;
	private List<Orders> orders;
	private Ticket ticket;
	private List<Ticket> tickets;
	
	@Before
	public void init() {
		order = new Orders();
		ticket = new Ticket();
		
	}
	
	@After
	public void destroy() {
		order = null;
		ticket = null;
		tickets = null;
	}
	
	@Test(expected = OrderNotFoundException.class)
	public void testRaiseTicket() throws OrderNotFoundException {
		service.raiseTicket(10010, "I have an request");
	}
	
	@Test
	public void testRaiseTicketCorrectDetails() throws OrderNotFoundException {
		ticket = service.raiseTicket(1001, "Ok");
		assertNotNull(ticket);
	}

	@Test(expected = TicketNotFoundException.class)
	public void testGetByTicketNumber() throws TicketNotFoundException {
		ticket = service.getByTicketNumber(11111);
	}

	@Test
	public void testListAllTickets() {
		tickets = service.listAllTickets();
		assertNotNull(tickets);
	}

	@Test
	public void testListUnresolvedTickets() {
		tickets = service.listUnresolvedTickets();
		assertNotNull(tickets);
	}

	@Test
	public void testListResolvedTickets() {
		tickets = service.listResolvedTickets();
		assertNotNull(tickets);
	}

	@Test(expected = TicketNotFoundException.class)
	public void testMarkAsResolved() throws TicketNotFoundException {
		int updated = service.markAsResolved(1001010);
	}

	@Test(expected = TicketNotFoundException.class)
	public void testSendResponse() throws TicketNotFoundException {
		ticket = service.sendResponse(100101, "Ok We will contact you soon with resolution");
	}

	@Test(expected = OrderNotFoundException.class)
	public void testGetByOrderId() throws TicketNotFoundException, OrderNotFoundException {
		ticket = service.getByOrderId(100101);
	}

	@Test
	public void testCountResolvedQueries() {
		int n = service.countResolvedQueries();
		assertEquals(1, n);
	}

	@Test
	public void testCountUnresolvedQueries() {
		int n = service.countUnresolvedQueries();
		assertEquals(1, n);
	}

	@Test(expected = TicketNotFoundException.class)
	public void testGetByLocation() throws TicketNotFoundException {
		tickets = service.getByLocation("Mumbai");
	}

	@Test
	public void testGetAllOrders() {
		orders = service.getAllOrders();
		assertNotNull(orders);
	}

	@Test
	public void testAddNewOrder() {
		Orders o = new Orders();
		o.setOrderId(1001);
		o.setQuantity(1);
		o.setAmount(1000);
		o.setAddress("Mumbai");
		o.setPaymentType("Credit");
		o.setOrderDate(new java.sql.Date(new Date().getTime()));
		order = service.addNewOrder(o);
		assertEquals(1001, o.getOrderId());
	}

	@Test
	public void testGetById() {
		order = service.getById(1001);
		assertEquals(1001, order.getOrderId());
	}

}
