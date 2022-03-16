package com.onlinegasbooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.GasBooking;
//import com.onlinegasbooking.repository.GasBookingRepository;
/*********************************************************************************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It is a service class that provides the services methods for adding,
 *          udating and deleting data                         
 *          Created at: 16-March-2022
 **********************************************************************************************/



@Service
public interface GasBookingService {
	
public GasBooking insertGasBooking(GasBooking gasBooking,Integer gasBookingId);
public GasBooking updateGasBooking(GasBooking gasBooking);
public GasBooking deleteGasBookingById(Integer gasBookingId);
public GasBooking calculateBill(GasBooking gasBooking);
//public List<GasBooking> getAllGasBooking();
}
