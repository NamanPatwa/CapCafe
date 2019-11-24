/**
 * 
 */
package com.cg.cafemenu.service;

import java.util.List;


import com.cg.cafemenu.dto.CafeMenu;
import com.cg.cafemenu.exception.MenuItemNotFoundException;

/**
 * @author admin
 *
 */
public interface CafeMenuService {
	

	
	CafeMenu addCafeMenu(CafeMenu cafemenu);
	
	CafeMenu fetchCafeMenuById(int itemId) throws MenuItemNotFoundException;
	
	CafeMenu fetchMenuItemByName(String name) throws MenuItemNotFoundException;
	
	List<CafeMenu> fetchAllCafeMenu();
	
	boolean removeCafeMenu(int itemId) throws MenuItemNotFoundException;
	
	CafeMenu updateCafeMenu(CafeMenu cafemenu);

}
