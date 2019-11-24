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

import com.cg.dto.CafeDetails;
import com.cg.service.CafeDetailsService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cafe")
public class CafeController {
	@Autowired
	CafeDetailsService service;
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public CafeDetails addMenuItem(@RequestBody CafeDetails cafe) {
		return service.addNewCafe(cafe);
	}
	@GetMapping(value = "/id/{id}", consumes = "application/json", produces = "application/json")
	public CafeDetails getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
	@GetMapping(value="all",produces="application/json")
	public List<CafeDetails> fetchAllCafes(){
		return service.fetchAllCafes();
	}
}
