package com.onlinegasbooking.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*********************************************************************************************
 *          @author: Vaishnavi Patil       
 *          @version: 1.0   
 *          Description: It contains the fields for Gas Booking such as gasBookingId, bookingDate,
 *          status,bill		                             
 *          Created at: 08-March-2022
 **********************************************************************************************/



@Entity

@Table(name = "egas_booking")

public class GasBooking {

	@Id
	@Column(name = "gas_booking_id")
	@GeneratedValue
	private Integer gasBookingId;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@NotNull(message = "status can not be null.")
	@Column(name = "status", length = 30)
	private String status;
	
	@NotNull(message = "Bill can not be null.")
	@Column(name = "bill")
	private Float bill;

	@ManyToOne
	@JsonIgnore
	private Customer customer;

	public GasBooking() {
		super();
	}

	public GasBooking(Integer gasBookingId, LocalDate bookingDate, String status, Float bill, Customer customer) {
		super();
		this.gasBookingId = gasBookingId;
		this.bookingDate = bookingDate;
		this.status = status;
		this.bill = bill;
		this.customer = customer;
	}

	public Integer getGasBookingId() {
		return gasBookingId;
	}

	public void setGasBookingId(Integer gasBookingId) {
		this.gasBookingId = gasBookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "GasBooking [gasBookingId=" + gasBookingId + ", bookingDate=" + bookingDate + ", status=" + status
				+ ", bill=" + bill + ", customer=" + customer + "]";
	}

	
	
	
}
