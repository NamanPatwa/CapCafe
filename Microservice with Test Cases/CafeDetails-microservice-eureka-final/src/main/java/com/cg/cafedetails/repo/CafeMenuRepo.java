package com.cg.cafedetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cafedetails.dto.CafeMenu;

public interface CafeMenuRepo extends JpaRepository<CafeMenu, Integer> {
//	CafeMenu findMenuItemByName(String itemName);

}
