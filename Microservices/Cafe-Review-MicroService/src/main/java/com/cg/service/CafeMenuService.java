package com.cg.service;

import java.util.List;

import com.cg.dto.CafeMenu;

public interface CafeMenuService {
CafeMenu addCafeMenu(CafeMenu menu);
CafeMenu getById(int menuId);
CafeMenu getByItemName(String itemName);
List<CafeMenu>findAllItems();
CafeMenu getByItemId(int itemId);

}
