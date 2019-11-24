package com.cg.cafedetails.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cafedetails.dto.CafeDetails;
import com.cg.cafedetails.exception.CafeDetailsNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CafeDetailsServiceImplTest {

	@Autowired
	private CafeDetailsService service;
	
	private CafeDetails cafe;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void init() {
		cafe = new CafeDetails();
		cafe.setCafeId(102);
		cafe.setCafeName("Starbucks");
		cafe.setCafeLocation("Bandra");
		cafe.setCafeOwner("Jack");
		cafe.setCafeRating(4.2);
		cafe.setCafeImagePath("src/felicita.jpg");
	}
	
	@Test
	public void testAddCafeDetails() {
		CafeDetails cafedetails = service.addCafeDetails(cafe);
		assertEquals(cafe.getCafeId(), cafedetails.getCafeId());
	}

	@Test
	public void testFetchCafeDetailsById() throws CafeDetailsNotFoundException {
		CafeDetails cafe = service.fetchCafeDetailsById(101);
		assertEquals(101, cafe.getCafeId());
	}
	
	@Test(expected = CafeDetailsNotFoundException.class)
	public void testFetchCafeDetailsByIdWithWrongId() throws CafeDetailsNotFoundException {
		CafeDetails cafe = service.fetchCafeDetailsById(101);
		assertEquals(101, cafe.getCafeId());
	}

	@Test
	public void testFetchAllCafeDetails() {
		assertEquals(2, service.fetchAllCafeDetails().size());
	}

	@Test
	public void testRemoveCafeDetails() throws CafeDetailsNotFoundException {
		assertTrue(service.removeCafeDetails(101));
	}
	
	@Test(expected = CafeDetailsNotFoundException.class)
	public void testRemoveCafeDetailsWithWrongId() throws CafeDetailsNotFoundException {
		assertTrue(service.removeCafeDetails(101));
	}

	@Test
	public void testUpdateCafeDetails() {
		cafe.setCafeLocation("Borivali");
		CafeDetails cafedetails = service.updateCafeDetails(cafe);
		assertEquals(cafe.getCafeLocation(), cafedetails.getCafeLocation());
	}

	
	@Test
	public void testFetchCafeDetailsByLocation() throws CafeDetailsNotFoundException {
		//List<CafeDetails> cafe = service.fetchCafeDetailsByLocation("Bandra");
		assertEquals(1, service.fetchCafeDetailsByLocation("Borivali").size());
	}

	@Test
	public void testFetchUniqueCafeLocation() {
		//List<String> cafe = service.fetchUniqueCafeLocation();
		assertEquals(2, service.fetchUniqueCafeLocation().size());
	}

	

}
