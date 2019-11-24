/**
 * 
 */
package com.cg.cafemenu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cafemenu.repo.CafeMenuRepo;
import com.cg.cafemenu.dto.CafeMenu;
import com.cg.cafemenu.exception.MenuItemNotFoundException;

/**
 * @author Noor
 *
 */
@Service
@Transactional(rollbackFor = MenuItemNotFoundException.class)

public class CafeMenuServiceImpl implements CafeMenuService {

	@Autowired
	private CafeMenuRepo menurepo;
	

	@Override
	public CafeMenu addCafeMenu(CafeMenu cafemenu) {
		return menurepo.save(cafemenu);
	}

	@Override
	public CafeMenu fetchCafeMenuById(int itemId) throws MenuItemNotFoundException {
		try {
			CafeMenu item= menurepo.findById(itemId).get();
			if(item==null)
				throw new MenuItemNotFoundException("");
			return item;
		} catch (Exception e) {
			throw new MenuItemNotFoundException("No Menu Item for Item Id: "+itemId);
		}
	}

	@Override
	public List<CafeMenu> fetchMenuItemByName(String name) throws MenuItemNotFoundException {
		try {
			List<CafeMenu> item = menurepo.findMenuItemByName(name);
			 if(item==null)
				 throw new MenuItemNotFoundException("");
			 return item;
		} catch (Exception e) {
			throw new MenuItemNotFoundException("No Matching Item Found");
		}
	}

	@Override
	public List<CafeMenu> fetchAllCafeMenu() {
		return menurepo.findAll();
	}

	@Override
	public boolean removeCafeMenu(int itemId) throws MenuItemNotFoundException {
		try {
			menurepo.deleteById(itemId);
			return true;
		} catch (Exception e) {
			throw new MenuItemNotFoundException("Invalid Menu Item ID provided.");
		}
	}

	@Override
	public CafeMenu updateCafeMenu(CafeMenu cafemenu) {
		return menurepo.save(cafemenu);
	}

}
