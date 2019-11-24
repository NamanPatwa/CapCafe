package com.cg.cafemenu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.cafemenu.dto.CafeMenu;
import com.cg.cafemenu.exception.MenuItemNotFoundException;
import com.cg.cafemenu.service.CafeMenuService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/menu")
public class CafeMenuController {
	
	@Autowired
	private CafeMenuService service;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public CafeMenu addMenuItem(@RequestBody CafeMenu cafemenu) {
		return service.addCafeMenu(cafemenu);
	}
	
	@GetMapping(value = "/{itemId}", produces = "application/json")
	public CafeMenu fetchMenuItemByID(@PathVariable int itemId) throws MenuItemNotFoundException {
		return service.fetchCafeMenuById(itemId);
	}
	
	@GetMapping(value = "name/{itemName}", produces = "application/json")
	public List<CafeMenu> fetchItemByName(@PathVariable String itemName) throws MenuItemNotFoundException {
		return service.fetchMenuItemByName(itemName);
	}
	
	@GetMapping(value = "fetchAll", produces = "application/json")
	public List<CafeMenu> fetchAllMenuItems(){
		return service.fetchAllCafeMenu();
	}
	
	@DeleteMapping(value = "remove/{itemId}", produces = "application/json")
	public boolean deleteMenuItem(@PathVariable int itemId) throws MenuItemNotFoundException {
		return service.removeCafeMenu(itemId);
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public CafeMenu updateMenuItemDetails(@RequestBody CafeMenu cafemenu) {
		return service.updateCafeMenu(cafemenu);
	}

}
