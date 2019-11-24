package com.cg.cafemenu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cafemenu.dto.CafeMenu;

public interface CafeMenuRepo extends JpaRepository<CafeMenu, Integer> {
	CafeMenu findMenuItemByName(String itemName);

}
