package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CafeMenu;

import com.cg.service.CafeMenuService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private CafeMenuService service;
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CafeMenu addMenuItem(@RequestBody CafeMenu menu) {
		return service.addCafeMenu(menu);
	}
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public CafeMenu getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
	@GetMapping(value = "/all", produces = "application/json")
	public List<CafeMenu> fetchAllItems() {
		return service.findAllItems();
	}
}
