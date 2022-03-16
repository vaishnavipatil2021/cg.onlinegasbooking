package com.onlinegasbooking.serviceImplimentation;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service; 
import com.onlinegasbooking.service.GasBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import com.onlinegasbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegasbooking.entity.Customer;
import com.onlinegasbooking.entity.GasBooking;
import com.onlinegasbooking.repository.GasBookingRepository;
import com.onlinegasbooking.repository.CustomerRepository;

/*********************************************************************************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It is a service class that provides the services for booking a cylinder,
 *          			  generate invoice, update status of gas booking and get all invoices                            
 *          Created at: 16-March-2022
 **********************************************************************************************/


@Service 
public class GasBookingServiceImplementation implements GasBookingService {
	
@Autowired
private GasBookingRepository gasBookingRepository;

@Autowired
public CustomerRepository customerRespository;

/*************************
 *  Method : insertGasBooking
 *  Description : To add the gasbooking by giving id as input.
 *  			  Used inbuilt save() method to add gasbooking.
 *  @param cid : id at which category want to find
 *
 *Created date : 11/03/2022
 ***************************/

@Transactional
public GasBooking insertGasBooking(GasBooking gasBooking, Integer cId)
{
	Optional<Customer> optionalCustomer = this.customerRespository.findById(cId);
	
//	optionalCustomer.get().setGasBooking(gasBookingRepository.save(gasBooking));
//	return customerRespository.save(optionalCustomer.get()).getGasBooking();
	optionalCustomer.get().setGasBooking(gasBookingRepository.save(gasBooking)); 
	// cylinder.setCustomer(optionalCustomer.get());
	return customerRespository.save(optionalCustomer.get()).getGasBooking();
}

/*************************
 *  Method :updateGasbookinggetCategory
 *  Description : To update the gasbooking if required. Used 
 *  inbuilt method save() to update gas booking
 *  @param cid : id at which category want to find
 *
 *Created date : 11/03/2022
 ***************************/
public GasBooking updateGasBooking(GasBooking gasBooking)
{   
	return gasBookingRepository.save(gasBooking);
}

/*************************
 *  Method :deleteGasbooking
 *  Description : To delete the gasbooking by gasbookingId
 *  @param cid : id at which category want to find
 *
 *Created date : 11/03/2022
 ***************************/
public GasBooking deleteGasBooking(Integer GasBookingId)
{
	return null; // gasBookingRepository.deleteGasBookingById(GasBookingId);
}

/*************************
 *  Method :calculateBill
 *  Description : To calculate the gasbooking bill used
 *  inbuilt method save()
 *  @param cid : id at which category want to find
 *
 *Created date : 11/03/2022
 ***************************/
public GasBooking calculateBill(GasBooking gasBooking) 
{
	return gasBookingRepository.save(gasBooking);
}

@Override
public GasBooking deleteGasBookingById(Integer gasBookingId) {
	
	Optional<GasBooking> optionalGasBooking = gasBookingRepository.findById(gasBookingId);
	Customer customer = optionalGasBooking.get().getCustomer();
	customer.setGasBookings(null);
	customerRespository.save(customer);
	gasBookingRepository.delete(optionalGasBooking.get());
	return optionalGasBooking.get();
}

}
