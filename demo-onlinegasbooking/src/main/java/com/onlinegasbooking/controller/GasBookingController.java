package com.onlinegasbooking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegasbooking.entity.Customer;
//import com.onlinegasbooking.entity.Cylinder;
import com.onlinegasbooking.entity.GasBooking;
import com.onlinegasbooking.repository.CustomerRepository;
import com.onlinegasbooking.repository.GasBookingRepository;
import com.onlinegasbooking.service.GasBookingService;

/*********************************************************************************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It is a GasBooking controller class that provides RestMappings inorder to 
 *          connect with the swagger
 *          			                           
 *          Created at: 16-March-2022
 **********************************************************************************************/



@RestController
public class GasBookingController {

	@Autowired
	private GasBookingService gasBookingService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//Add a customer to database
	//post methods
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	@GetMapping("/customer/{cid}")
	public Customer getCustomer(@PathVariable("cid") Integer cId ) {
		return customerRepository.findById(cId).get();
	}
	
	//Add a gasbooking to database
	//post mapping
	@PostMapping("/gasbooking/{custd}")
	public GasBooking insertGasBooking(@Valid @RequestBody GasBooking gasbooking,@PathVariable("custd") Integer cId) {
		return gasBookingService.insertGasBooking(gasbooking, cId);
	}
	
	//Update the details of gasbookings if required
	//put methods
	@PutMapping("/gasbooking")
	public GasBooking updateGasBooking(@Valid @RequestBody GasBooking gasbooking) {
		return gasBookingService.updateGasBooking(gasbooking);
	}
	
	//delete the gasbookingId from DB
	//Get methods
	@DeleteMapping("/gasbooking/{gasbookingid}")
	public GasBooking deleteGasBookingById(@PathVariable("gasbookingid") Integer gasBookingId) {
		return gasBookingService.deleteGasBookingById(gasBookingId);
	}

}
