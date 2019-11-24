package com.cg.cafemenu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.cafemenu.dto.CafeMenu;

public interface CafeMenuRepo extends JpaRepository<CafeMenu, Integer> {
	
	@Query("SELECT i FROM CafeMenu i WHERE i.itemName = :itemName")
	List<CafeMenu> findMenuItemByName(@Param("itemName") String itemName);
	
//	@Query("SELECT i FROM CafeMenu i WHERE i.details.cafeId = :cadeId")
//	List<CafeMenu> findByCafeId(@Param("id") int id);
}
