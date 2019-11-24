package com.cg.cafedetails.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cg.cafedetails.dto.CafeDetails;
import com.cg.cafedetails.dto.CafeMenu;
import com.cg.cafedetails.dto.Employee;
import com.cg.cafedetails.dto.Order;
import com.cg.cafedetails.dto.OrderDetail;
import com.cg.cafedetails.dto.ReviewsAndRatings;
import com.cg.cafedetails.dto.Ticket;
import com.cg.cafedetails.exception.CafeDetailsNotFoundException;
import com.cg.cafedetails.exception.CafeNotFound;
import com.cg.cafedetails.exception.EmployeeNotFoundException;
import com.cg.cafedetails.exception.EmployeeNotSavedException;
import com.cg.cafedetails.exception.FeedbackNotFound;
import com.cg.cafedetails.exception.ItemNotFound;
import com.cg.cafedetails.exception.MenuItemNotFoundException;
import com.cg.cafedetails.exception.OrderNotFoundException;
import com.cg.cafedetails.exception.TicketNotFoundException;
import com.cg.cafedetails.exception.UserNotFound;
import com.cg.cafedetails.exception.WrongPasswordException;
import com.cg.cafedetails.exception.WrongSecurityAnswerException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/cafefront")
public class CafeController {
	
	@Autowired
	RestTemplate resttemplate ;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public CafeDetails addCafeDetails(@RequestBody CafeDetails cafedetails) {
		CafeDetails c = resttemplate.postForObject("http://cafe-details-service/cafedetails/add", cafedetails, CafeDetails.class);
		return c;
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public CafeDetails fetchCafeDetailsById(@PathVariable int id) throws CafeDetailsNotFoundException {
		CafeDetails c;
		try {
			c = resttemplate.getForObject("http://cafe-details-service/cafedetails/" + id, CafeDetails.class);
		} catch (RestClientException e) {
			throw new CafeDetailsNotFoundException("No cafe details are available for cafeId: " + id);
		}
		return c;
	}
	
	@GetMapping(value = "fetchAllCafe", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetails() {
		CafeDetails[] c = resttemplate.getForObject("http://cafe-details-service/cafedetails/fetchAllCafe", CafeDetails[].class);
		return Arrays.asList(c);
	}
	
	@DeleteMapping(value = "remove/{id}", produces = "application/json")
	public boolean removeCafeDetails(@PathVariable int id) throws CafeDetailsNotFoundException {
		try {
			resttemplate.delete("http://cafe-details-service/cafedetails/remove/"+ id , id);
		} catch (RestClientException e) {
			throw new CafeDetailsNotFoundException("Invalid Cafe Id provided: " + id);
		}
		return true;
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public CafeDetails updateCafeDetails(@RequestBody CafeDetails cafedetails) {
		resttemplate.put("http://cafe-details-service/cafedetails/update", cafedetails);
		return cafedetails;
	}
	
	@GetMapping(value = "/byLocation/{location}", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetailsByLocation(@PathVariable String location) throws CafeDetailsNotFoundException {
		CafeDetails[] c;
		try {
			c = resttemplate.getForObject("http://cafe-details-service/cafedetails/byLocation/" + location , CafeDetails[].class);
		} catch (RestClientException e) {
			throw new CafeDetailsNotFoundException("No Cafe found for this Location: " + location);
		}
		return Arrays.asList(c);
	}
	
	@GetMapping(value = "/uniqueLocation", produces = "application/json")
	public List<String> fetchUniqueCafeLocation() {
		String[] c = resttemplate.getForObject("http://cafe-details-service/cafedetails/uniqueLocation", String[].class);
		return Arrays.asList(c);
	}
//----------------------------------------------------------------	
	@PostMapping(value = "/menu/add", consumes = "application/json", produces = "application/json")
	public CafeMenu addMenuItem(@RequestBody CafeMenu cafemenu) {
		CafeMenu c = resttemplate.postForObject("http://cafe-menu-service/menu/add", cafemenu, CafeMenu.class);
		return c;
	}
	
	@GetMapping(value = "/menu/{itemId}", produces = "application/json")
	public CafeMenu fetchMenuItemByID(@PathVariable int itemId) throws MenuItemNotFoundException {
		CafeMenu c = null;
		try {
			c = resttemplate.getForObject("http://cafe-menu-service/menu/" + itemId , CafeMenu.class);
		} catch (RestClientException e) {
			throw new MenuItemNotFoundException("No Menu Item for Item Id: "+itemId);
		}
		return c;
	}
	
	@GetMapping(value = "name/{itemName}", produces = "application/json")
	public List<CafeMenu> fetchItemByName(@PathVariable String itemName) throws MenuItemNotFoundException {
		CafeMenu[] c = null;
		try {
			c = resttemplate.getForObject("http://cafe-menu-service/menu/name/" + itemName, CafeMenu[].class);
		} catch (RestClientException e) {
			throw new MenuItemNotFoundException("No Matching Item Found");
		}
		return Arrays.asList(c);
	}
	
	@GetMapping(value = "fetchAll", produces = "application/json")
	public List<CafeMenu> fetchAllMenuItems(){
		CafeMenu[] c = resttemplate.getForObject("http://cafe-menu-service/menu/fetchAll", CafeMenu[].class);
		return Arrays.asList(c);
	}
	
	@DeleteMapping(value = "menu/remove/{itemId}", produces = "application/json")
	public boolean deleteMenuItem(@PathVariable int itemId) throws MenuItemNotFoundException {
		try {
			resttemplate.delete("http://cafe-menu-service/menu/remove/"+ itemId , itemId);
		} catch (RestClientException e) {
			throw new MenuItemNotFoundException("Invalid Menu Item ID provided.");
		}
		return true;
	}
	
	@PutMapping(value = "menu/update", consumes = "application/json", produces = "application/json")
	public CafeMenu updateMenuItemDetails(@RequestBody CafeMenu cafemenu) {
		resttemplate.put("http://cafe-menu-service/menu/update", cafemenu);
		return cafemenu;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////
	
	
	
	@PostMapping(value = "order/add", consumes = "application/json", produces = "application/json")
	public int addItems(@RequestBody Order order) {
		int c = resttemplate.postForObject("http://cafe-order-service/order/add", order, Integer.class);
		return c;
	}
	
	@GetMapping(value = "order/{id}", produces = "application/json")
	public Order fetchOrderById(@PathVariable int id)  {
		Order o = resttemplate.getForObject("http://cafe-order-service/order/" + id , Order.class);
		return o;
	}
	
	@GetMapping(value = "order/AllOrders", produces = "application/json")
	public List<Order> fetchAllOrder() {
		Order[] o = resttemplate.getForObject("http://cafe-order-service/order/AllOrders" , Order[].class);
		return Arrays.asList(o);
	}
	
	@DeleteMapping(value = "order/remove", produces = "application/json")
	public boolean removeOrder(@RequestParam int id) {
		resttemplate.delete("http://cafe-order-service/order/remove/"+ id , id);
		return true;
	}
	
	@GetMapping(value = "order/byName/{name}", produces = "application/json")
	public List<Order> fetchAllCafeDetailsByName(@PathVariable String name){
		Order[] o = resttemplate.getForObject("http://cafe-order-service/order/byName/" +name , Order[].class);
		return Arrays.asList(o);
	}
	
	@GetMapping(value = "order/byid/{id}", produces = "application/json")
	public List<Order> fetchOrderByEmployeeId(@PathVariable("id") int id){
		Order[] o = resttemplate.getForObject("http://cafe-order-service/order/byid/" + id , Order[].class);
		return Arrays.asList(o);
	}
	
	@GetMapping(value = "order/Date/{date}", produces = "application/json")
	public List<Order> fetchOrderByDate(@RequestParam Date date) {
		Order[] o = resttemplate.getForObject("http://cafe-order-service/order/Date/" +date , Order[].class);
		return Arrays.asList(o);
	}
	
	@GetMapping(value = "order/item/{id}", produces = "application/json")
	public List<OrderDetail>  fetchOrderDetailByOrderId(@PathVariable("id") int id)  {
		OrderDetail[] o = resttemplate.getForObject("http://cafe-order-service/order/item/" +id , OrderDetail[].class);
		return Arrays.asList(o);
	}
	
	//////////////////////////////////////////////////////////////////
	
	@PostMapping(value = "/ticket/add/{id}/{msg}", produces = "application/json")
	public Ticket raiseTicket(@PathVariable("id") int id, @PathVariable("msg") String msg) throws OrderNotFoundException {
		Ticket t = null;
		try {
			resttemplate.postForObject("http://cafe-helpdesk-service/helpdesk/ticket/add/" + id +"/" + msg, id, Ticket.class);
		} catch (RestClientException e) {
			throw new OrderNotFoundException("Order not found with orderid: "+id);
		}
		return t;
	}
	
	@PostMapping(value = "/ticket/response/{ticketNumber}/{msg}", produces = "application/json")
	public Ticket giveResponse(@PathVariable("ticketNumber") int ticketNumber, @PathVariable("msg") String msg) throws TicketNotFoundException {
		Ticket t = null;
		try {
			resttemplate.postForObject("http://cafe-helpdesk-service/helpdesk/ticket/response/" + ticketNumber +"/" + msg , msg, Ticket.class);
		} catch (RestClientException e) {
			throw new TicketNotFoundException("Ticket not found!");
		}
		return t;
	}
	
	@GetMapping(value = "/ticket/list", produces = "application/json")
	public List<Ticket> allTickets(){
		Ticket[] o = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/list", Ticket[].class);
		return Arrays.asList(o);
	}
	
	@GetMapping(value = "ticket/id/{id}", produces = "application/json")
	public Ticket getByTicketId(@PathVariable("id") int id) throws TicketNotFoundException {
		Ticket t = null;
		try {
			t = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/id/" + id , Ticket.class);
		} catch (RestClientException e) {
			throw new TicketNotFoundException("Ticket not found with id: "+id);
		}
		return t;
	}
	
	@GetMapping(value = "/ticket/list/resolved", produces = "application/json")
	public List<Ticket> getResolvedTickets(){
		Ticket[] t = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/list/resolved" , Ticket[].class);
		return Arrays.asList(t);
	}
	
	@GetMapping(value = "/ticket/count/resolved")
	public int countResolvedTickets() {
		int c = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/count/resolved" , Integer.class);
		return c;
	}
	
	@GetMapping(value = "/ticket/count/unresolved")
	public int countUnresolvedTickets() {
		int c = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/count/unresolved" , Integer.class);
		return c;
	}
	
	@GetMapping(value = "/ticket/list/unresolved", produces = "application/json")
	public List<Ticket> getUnresolvedTickets(){
		Ticket[] t = resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/list/unresolved" , Ticket[].class);
		return Arrays.asList(t);
	}

	@GetMapping(value = "/ticket/orderid/{orderId}", produces = "application/json")
	public Ticket getTicketByOrderId(@PathVariable("orderId") int orderId) throws TicketNotFoundException, OrderNotFoundException {
		Ticket t = null; 
		try {
			ResponseEntity<Ticket> response = resttemplate.exchange("http://cafe-helpdesk-service/helpdesk/ticket/orderid/" + orderId , HttpMethod.GET, null, Ticket.class);
			t = response.getBody();
		} catch (HttpClientErrorException e) {
			throw new TicketNotFoundException(e.getResponseBodyAsString());
		}
		return t;
	}
	
	@GetMapping(value = "/ticket/list/location/{location}", produces = "application/json")
	public List<Ticket> getByLocation(@PathVariable("location") String location) throws TicketNotFoundException{
		Ticket[] t = null;
		try {
			resttemplate.getForObject("http://cafe-helpdesk-service/helpdesk/ticket/list/location/" + location , Ticket[].class);
		} catch (RestClientException e) {
			throw new TicketNotFoundException("Ticket not found for location "+location);
		}
		return Arrays.asList(t);
	}
	
	@PutMapping(value = "/ticket/resolve/{ticketNumber}")
	public int markAsResolved(@PathVariable("ticketNumber") int ticketNumber) throws TicketNotFoundException {
		try {
			resttemplate.put("http://cafe-helpdesk-service/helpdesk/ticket/resolve/" + ticketNumber, Integer.class);
		} catch (RestClientException e) {
			throw new TicketNotFoundException("Ticket not found with ticket number "+ ticketNumber);
		}
		return 1;
	}
	
	@GetMapping(value = "ticketorder/all", produces = "application/json")
	public List<Order> getAllTickets(){
		Order[] t = resttemplate.getForObject("http://cafe-helpdesk-service/order/all" , Order[].class);
		return Arrays.asList(t);
	}
	
	@GetMapping(value = "ticketorder/id/{id}", produces = "application/json")
	public Order getById(@PathVariable("id") int id) {
		Order t = resttemplate.getForObject("http://cafe-helpdesk-service/order/id/" + id , Order.class);
		return t;
	}
	
	@GetMapping(value = "ticketorder/location/{location}", produces = "application/json")
	public List<Order> listByLocation(@PathVariable("location") String location) throws OrderNotFoundException{
		Order[] t;
		try {
			t = resttemplate.getForObject("http://cafe-helpdesk-service/order/location/" + location , Order[].class);
		} catch (RestClientException e) {
			throw new OrderNotFoundException("Order not found for location "+location);
		}
		return Arrays.asList(t);
	}
	
	///////////////////////////authentication////////////
	@PostMapping(value = "/auth/add")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeNotSavedException {
		Employee e = resttemplate.postForObject("http://cafe-authentication-service/capcafe/add/"  , employee, Employee.class);
		return e;
		
	}

	@GetMapping(value = "/auth/id/{id}")
	public Employee getById(@PathVariable String id) throws EmployeeNotFoundException {
		Employee e = new Employee();
		HttpEntity<String> requestEntity = new HttpEntity<String>(id);
		try {
			ResponseEntity<Employee> response = resttemplate.exchange("http://cafe-authentication-service/capcafe/id/" + id , HttpMethod.GET, requestEntity, Employee.class);
			e = response.getBody();
		} catch (HttpClientErrorException e1) {
			throw new EmployeeNotFoundException(e1.getResponseBodyAsString());
		}
		return e;
	}
	
	@PutMapping(value = "/auth/update")
	public Employee update(@RequestBody Employee employee) {
		resttemplate.put("http://cafe-authentication-service/capcafe/update/" , Employee.class);
		return employee;
	}

	@PutMapping(value = "/auth/chng/{id}/{prevpass}/{newpass}")
	public boolean newPassword(@PathVariable String id, @PathVariable String prevpass, @PathVariable String newpass)
			throws EmployeeNotFoundException, WrongPasswordException {
		//HttpEntity requestEntity = new HttpEntity<>(null);
		try {
			resttemplate.exchange("http://cafe-authentication-service/capcafe/chng/" + id + "/" + prevpass + "/" + newpass , HttpMethod.PUT, null, Boolean.class);
		} catch (HttpClientErrorException e) {
			throw new EmployeeNotFoundException(e.getResponseBodyAsString());
		}
		return true;
	}

	@GetMapping(value = "/auth/login/{id}/{password}")
	public Employee login(@PathVariable String id, @PathVariable String password)
			throws EmployeeNotFoundException, WrongPasswordException {	
		Employee e = new Employee();
		try {
			ResponseEntity<Employee> response = resttemplate.exchange("http://cafe-authentication-service/capcafe/login/" + id + "/" + password , HttpMethod.GET,null, Employee.class);
			e = response.getBody();
		} catch (HttpClientErrorException e1) {
			throw new EmployeeNotFoundException(e1.getResponseBodyAsString());
		}
		return e;
	}
	
	@GetMapping(value = "/auth/all")
	public List<Employee> getAll() throws EmployeeNotFoundException {
		Employee[] e = null;
		try {
			e = resttemplate.getForObject("http://cafe-authentication-service/capcafe/all" , Employee[].class);
		} catch (RestClientException e1) {
			throw new EmployeeNotFoundException("User list is empty");
		}
		return Arrays.asList(e);
	}

	@GetMapping(value = "/auth/question/{id}")
	public String getSecurityQuestion(@PathVariable String id) throws EmployeeNotFoundException{
		String question;
		try {
			question = resttemplate.getForObject("http://cafe-authentication-service/capcafe/question/" + id , String.class);
		} catch (RestClientException e) {
			throw new EmployeeNotFoundException("Employee not found with ID: "+id);
		}
		return question;
	}
	
	@PutMapping(value = "/auth/forgotpass/{employeeId}/{answer}/{password}")
	public boolean forgotPassword(@PathVariable String employeeId,@PathVariable String answer,@PathVariable String password) throws EmployeeNotFoundException, WrongSecurityAnswerException{
		try {
			resttemplate.exchange("http://cafe-authentication-service/capcafe/forgotpass/" + employeeId + "/" + answer + "/" + password, HttpMethod.PUT, null, Boolean.class);
		} catch (HttpClientErrorException e) {
			throw new EmployeeNotFoundException(e.getResponseBodyAsString());
		}
		return true;
	}
	
	///////////////////////// Review //////////////////////////////////////////////////////
	
	
	@PostMapping(value = "/addItemReview/{userId}/{itemName}/{type}/{review}", produces = "application/json")
	public ReviewsAndRatings giveReviewToItem(@PathVariable("userId") String userId,@PathVariable("itemName") String itemName,@PathVariable("type") String type,@PathVariable("review") String review) throws ItemNotFound, UserNotFound {
		ReviewsAndRatings e = resttemplate.postForObject("http://cafe-review-service/feedback/addItemReview/" + userId +"/" + itemName + "/" + type + "/" + review , itemName,  ReviewsAndRatings.class);
		return e;
	}
	@PostMapping(value = "/addItemRating/{userId}/{itemName}/{type}/{rating}", produces = "application/json")
	public ReviewsAndRatings giveRatingToItem(@PathVariable("userId") String userId,@PathVariable("itemName") String itemName ,@PathVariable("type") String type,@PathVariable("rating") int rating) throws ItemNotFound, UserNotFound {
		ReviewsAndRatings e = resttemplate.postForObject("http://cafe-review-service/feedback/addItemRating/" + userId +"/" + itemName + "/" + type + "/" + rating , itemName,  ReviewsAndRatings.class);
		return e;
	}
	
	@PostMapping(value = "/addCafeRating/{userId}/{cafeLocation}/{type}/{rating}", produces = "application/json")
	public ReviewsAndRatings giveRatingToCafe(@PathVariable("userId") String userId,@PathVariable("cafeLocation") String cafeLocation,@PathVariable("type") String type,@PathVariable("rating") int rating) throws CafeNotFound, UserNotFound {
		ReviewsAndRatings e = resttemplate.postForObject("http://cafe-review-service/feedback/addCafeRating/" + userId +"/" + cafeLocation + "/" + type + "/" + rating , cafeLocation,  ReviewsAndRatings.class);
		return e;
	}
	
	@PostMapping(value = "/addCafeReview/{userId}/{cafeName}/{type}/{review}", produces = "application/json")
	public ReviewsAndRatings giveReviewToCafe(@PathVariable("userId") String userId,@PathVariable("cafeName") String cafeName,@PathVariable("type") String type,@PathVariable("review") String review) throws CafeNotFound, UserNotFound {
		ReviewsAndRatings e = resttemplate.postForObject("http://cafe-review-service/feedback/addCafeReview/" + userId +"/" + cafeName + "/" + type + "/" + review , cafeName,  ReviewsAndRatings.class);
		return e;
	}
	
	@GetMapping(value = "/getAll",produces = "application/json")
	public List<ReviewsAndRatings> fetchAll() throws FeedbackNotFound {
		ReviewsAndRatings[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getAll" , ReviewsAndRatings[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value = "/getFeedbackByItemName/{itemName}",produces = "application/json")
	 public List<ReviewsAndRatings> fetchByItemName(@PathVariable  String itemName) throws ItemNotFound {
		ReviewsAndRatings[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getFeedbackByItemName/" + itemName , ReviewsAndRatings[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value="/getFeedbackByCafeLocation/{cafeLocation}",produces="application/json")
	public List<ReviewsAndRatings> fetchByCafeLocation(@PathVariable String cafeLocation) throws CafeNotFound{
		ReviewsAndRatings[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getFeedbackByCafeLocation/" + cafeLocation , ReviewsAndRatings[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value="/getItemAverageRating/{itemId}",produces="application/json")
	public double fetchItemAverageRating(@PathVariable int itemId) throws ItemNotFound{
		double e = resttemplate.getForObject("http://cafe-review-service/feedback/getItemAverageRating/" + itemId , Double.class);
		return e;
	}
	
	@GetMapping(value="/getCafeAverageRating/{cafeId}",produces="application/json")
	public double fetechCafeAverageRating(@PathVariable int cafeId) throws CafeNotFound {
		double e = resttemplate.getForObject("http://cafe-review-service/feedback/getCafeAverageRating/" + cafeId , Double.class);
		return e;
	}

	@GetMapping(value="/getReviewByCafeLocation/{cafeLocation}",produces="application/json")
	public List<String> fetchCafeReviews(@PathVariable String cafeLocation) {
		String[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getReviewByCafeLocation/" + cafeLocation , String[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value="/getReviewByItemName/{itemName}",produces="application/json")
	public List<String> fetchItemReviews(@PathVariable String itemName) {
		String[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getReviewByItemName/" + itemName , String[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value="/getReviewByCafeId/{cafeId}",produces="application/json")
	public List<ReviewsAndRatings> fetchCafeReviewsById(@PathVariable int cafeId) {
		ReviewsAndRatings[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getReviewByCafeId/" + cafeId , ReviewsAndRatings[].class);
		return Arrays.asList(e);
	}
	
	@GetMapping(value="/getReviewByItemId/{itemId}",produces="application/json")
	public List<ReviewsAndRatings> fetchItemReviewsById(@PathVariable int itemId) {
		ReviewsAndRatings[] e = resttemplate.getForObject("http://cafe-review-service/feedback/getReviewByItemId/" + itemId , ReviewsAndRatings[].class);
		return Arrays.asList(e);
	}

}
