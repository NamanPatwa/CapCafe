/**
 * 
 */
package com.cg.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.dto.Order;
import com.cg.dto.OrderDetail;
import com.cg.exception.OrderCanNotBeSavedException;
import com.cg.exception.OrderNotFoundException;
import com.cg.service.OrderService;
import com.cg.service.OrderServiceImpl;

/**
 * @author Dell
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {
	
	@Autowired
	OrderService service;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	void setUp() throws Exception {
		service = new OrderServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Test method for {@link com.cg.service.OrderService#addOrder(com.cg.dto.Order)}.
	 * @throws OrderCanNotBeSavedException 
	 */
	@Test
	void testAddOrder() throws OrderCanNotBeSavedException {
		Order order = new Order();
		order.setEmployeeAddress("Marol");
		order.setEmployeeId(1001);
		order.setEmployeeMail("prem@gmail.com");
		order.setEmployeeName("PremChandra");
		order.setEmployeePhone("9090909090");
		order.setLocation("Andheri");
		order.setOrderDetails(Collections.<OrderDetail>emptySet());
		order.setOrderId(505);
		order.setPaymentType("UPI");
		order.setTotalAmount(250.00);
		int id = service.addOrder(order);
		assertEquals(1,id);
	}
	/**
	 * Negative Test method for {@link com.cg.service.OrderService#addOrder(com.cg.dto.Order)}.
	 * @throws OrderCanNotBeSavedException 
	 */
	@Test
	void negativeTestAddOrder() throws OrderCanNotBeSavedException {
		Order order = new Order();
		order.setEmployeeAddress("Marol");
		order.setEmployeeId(1001);
		order.setEmployeeMail("prem@gmail.com");
		order.setEmployeeName("PremChandra");
		order.setEmployeePhone("9090909090");
		order.setOrderDetails(Collections.<OrderDetail>emptySet());
		order.setOrderId(505);
		order.setPaymentType("UPI");
		order.setTotalAmount(250.00);
		Assertions.assertThrows(OrderCanNotBeSavedException.class, () ->{service.addOrder(order);});
	}

	/**
	 * Test method for {@link com.cg.service.OrderService#fetchOrderById(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchOrderById() throws OrderNotFoundException {
	assertNotNull(service.fetchOrderById(1));		
	}
	
	/**
	 *Negative Test method for {@link com.cg.service.OrderService#fetchOrderById(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void negativeTestFetchOrderById() throws OrderNotFoundException {
     Assertions.assertThrows(OrderNotFoundException.class, () ->{service.fetchOrderById(1000);});
	
	}

	/**
	 * Test method for {@link com.cg.service.OrderService#fetchAllOrder()}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchAllOrder() throws OrderNotFoundException {
		assertNotNull(service.fetchAllOrder().size());
	}

	/**
	 * Test method for {@link com.cg.service.OrderService#fetchOrderDetailsByName(java.lang.String)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchOrderDetailsByName() throws OrderNotFoundException {
		String name="Naman";
		assertNotNull(service.fetchOrderDetailsByName(name));
	}
	
	/**
	 * Negative Test method for {@link com.cg.service.OrderService#fetchOrderDetailsByName(java.lang.String)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void negativeTestFetchOrderDetailsByName() throws OrderNotFoundException {
		String name="Namanee";
		Assertions.assertThrows(OrderNotFoundException.class, () ->{service.fetchOrderDetailsByName(name);});
	}
	/**
	 * Test method for {@link com.cg.service.OrderService#fetchOrderByPriceRange(double, double)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchOrderByPriceRange() throws OrderNotFoundException {
		assertNotNull(service.fetchOrderByPriceRange(200,900));
	}
	
	/**
	 * Negative Test method for {@link com.cg.service.OrderService#fetchOrderByPriceRange(double, double)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void negativeTestFetchOrderByPriceRange() throws OrderNotFoundException {
		Assertions.assertThrows(OrderNotFoundException.class, () ->{service.fetchOrderByPriceRange(20000,90000);});
	}

	/**
	 * Test method for {@link com.cg.service.OrderService#fetchOrderByEmployeeId(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchOrderByEmployeeId() throws OrderNotFoundException {
		assertNotNull(service.fetchOrderByEmployeeId(7));
	}
	
	/**
	 *Negative Test method for {@link com.cg.service.OrderService#fetchOrderByEmployeeId(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void negativeTestFetchOrderByEmployeeId() throws OrderNotFoundException {
		Assertions.assertThrows(OrderNotFoundException.class, () ->{service.fetchOrderByEmployeeId(17);});
	}

	/**
	 *Test method for {@link com.cg.service.OrderService#fetchItemDetailsByOrderId(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void testFetchItemDetailsByOrderId() throws OrderNotFoundException {
		assertNotNull(service.fetchItemDetailsByOrderId(4));
	}
	/**
	 * Negative Test method for {@link com.cg.service.OrderService#fetchItemDetailsByOrderId(int)}.
	 * @throws OrderNotFoundException 
	 */
	@Test
	void negativeTestFetchItemDetailsByOrderId() throws OrderNotFoundException {
		Assertions.assertThrows(OrderNotFoundException.class, () ->{service.fetchItemDetailsByOrderId(54);});
	}

}
