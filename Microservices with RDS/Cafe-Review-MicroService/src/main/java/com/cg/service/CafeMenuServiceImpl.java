package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.CafeMenu;
import com.cg.repo.CafeMenuRepo;
@Service
@Transactional
public class CafeMenuServiceImpl implements CafeMenuService {
@Autowired
CafeMenuRepo repo;
	@Override
	public CafeMenu addCafeMenu(CafeMenu menu) {
		return repo.save(menu);
	}
	@Override
	public CafeMenu getById(int menuId) {
		return repo.findById(menuId).get();
	}
	@Override
	public CafeMenu getByItemName(String itemName) {
		return repo.getByItemName(itemName);
	}
	@Override
	public List<CafeMenu> findAllItems() {
		return repo.findAll();
	}
	@Override
	public CafeMenu getByItemId(int itemId) {
		return repo.getByItemId(itemId);
	}


}
