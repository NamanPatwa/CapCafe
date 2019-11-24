/**
 * 
 */
package com.cg.cafemenu.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cafemenu.dto.CafeMenu;
import com.cg.cafemenu.exception.MenuItemNotFoundException;
import com.cg.cafemenu.service.CafeMenuService;
import com.cg.cafemenu.service.CafeMenuServiceImpl;

/**
 * @author Noor U Din
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CafeMenuServiceTest {

	@Autowired
	CafeMenuService service;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	void setUp() throws Exception {
		service = new CafeMenuServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	void tearDown() throws Exception {
		service = null;
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#addCafeMenu(com.cg.cafemenu.dto.CafeMenu)}.
	 */
	@Test
	void testAddCafeMenu() {
		CafeMenu item = new CafeMenu(1021,"Milk","Veg",80.0);
		assertNotNull(service.addCafeMenu(item));
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#fetchCafeMenuById(int)}.
	 * @throws MenuItemNotFoundException 
	 */
	@Test
	void testFetchCafeMenuById() throws MenuItemNotFoundException {
		assertNotNull(service.fetchCafeMenuById(1020));
	}
	
	@Test
	void testFetchCafeMenuByIdWithException() throws MenuItemNotFoundException {
		
		Assertions.assertThrows(MenuItemNotFoundException.class,()-> service.fetchCafeMenuById(2000));
		
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#fetchMenuItemByName(java.lang.String)}.
	 */
	@Test
	void testFetchMenuItemByName() {
		try {
			assertNotNull(service.fetchMenuItemByName("Tea"));
		} catch (Exception e) {
			System.out.println("Exception Happened");
		}
	
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#fetchAllCafeMenu()}.
	 */
	@Test
	void testFetchAllCafeMenu() {
		assertNotEquals(0, service.fetchAllCafeMenu().size());
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#removeCafeMenu(int)}.
	 */
	@Test
	void testRemoveCafeMenu() {
		try {
			assertTrue(service.removeCafeMenu(1020));
		} catch (MenuItemNotFoundException e) {
			System.out.println("Exception Happened");
		}
		
	}

	/**
	 * Test method for {@link com.cg.cafemenu.service.CafeMenuService#updateCafeMenu(com.cg.cafemenu.dto.CafeMenu)}.
	 */
	@Test
	void testUpdateCafeMenu() {
		CafeMenu item = new CafeMenu(1021,"Coke","Veg",30.0);
		assertNotNull(service.updateCafeMenu(item));
		
	}

}
