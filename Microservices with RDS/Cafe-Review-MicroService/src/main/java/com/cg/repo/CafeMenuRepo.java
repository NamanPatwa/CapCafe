package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.dto.CafeMenu;

public interface CafeMenuRepo extends JpaRepository<CafeMenu, Integer>{
@Query("SELECT m FROM CafeMenu m WHERE m.itemName = :itemName")
CafeMenu getByItemName(@Param("itemName") String itemName);
@Query("SELECT m FROM CafeMenu m WHERE m.itemId = :itemId")
CafeMenu getByItemId(int itemId);

}
