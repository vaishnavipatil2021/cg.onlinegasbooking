package com.onlinegasbooking.service;

import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.SurrenderCylinder;
@Service
public interface SurrenderCylinderService {
      
	public SurrenderCylinder addSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public SurrenderCylinder updateSurrenderCylinder(SurrenderCylinder surrenderCylinder);
	public SurrenderCylinder deleteSurrenderCylinder(Integer surrenderId);
	public Integer countSurrenderCylinder();

}
