package com.cg.service;

import java.util.List;

import com.cg.dto.CafeDetails;

public interface CafeDetailsService {
CafeDetails addNewCafe(CafeDetails cafe);
CafeDetails getById(int cafeId);
CafeDetails getByCafeLocation(String cafeLocation);
List<CafeDetails> fetchAllCafes();
CafeDetails getByCafeId(int cafeId);
CafeDetails getByCafeName(String cafeName);

}
