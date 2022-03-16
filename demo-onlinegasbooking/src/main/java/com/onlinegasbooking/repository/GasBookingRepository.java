package com.onlinegasbooking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.onlinegasbooking.exception.GasBookingNotFoundException;
import com.onlinegasbooking.entity.GasBooking;

@Repository
public interface GasBookingRepository extends JpaRepository< GasBooking, Integer> {
//	public GasBooking insertGasBooking(GasBooking gasBooking);
//	public GasBooking updateGasBooking(GasBooking gasBooking);
//	public GasBooking deleteGasBooking(GasBooking gasBooking); 
//	public GasBooking calculateBill(int customerId);

}
