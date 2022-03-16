package com.onlinegasbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "egas_cylinder_connection")

public class Cylinder {

	@Id
	@Column(name = "cylinder_type_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
	@SequenceGenerator(name = "seq2", sequenceName = "egas_seq2", allocationSize = 1)
	private Integer cylinderTypeId;

	@Column(name = "cylinder_type", length = 10, nullable = false)
	private String cylinderType;

	@Column(name = "weight")
	private Float weight;
	
	@Column(name = "price")
	private Float price;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "surrender_id", referencedColumnName = "surrender_id")
	private SurrenderCylinder surrendercylinder = new SurrenderCylinder();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", referencedColumnName = "customer_id")
	private Customer customer;
	public Cylinder() {
		super();
	}

	public Cylinder(Integer cylinderTypeId, String cylinderType, Float weight, Float price, Customer customer,
			SurrenderCylinder surrendercylinder) {
		super();
		this.cylinderTypeId = cylinderTypeId;
		this.cylinderType = cylinderType;
		this.weight = weight;
		this.price = price;
		this.customer = customer;
		this.surrendercylinder = surrendercylinder;
	}

	public Integer getCylinderTypeId() {
		return cylinderTypeId;
	}

	public void setCylinderTypeId(Integer cylinderTypeId) {
		this.cylinderTypeId = cylinderTypeId;
	}

	public String getCylinderType() {
		return cylinderType;
	}

	public void setCylinderType(String cylinderType) {
		this.cylinderType = cylinderType;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SurrenderCylinder getSurrendercylinder() {
		return surrendercylinder;
	}

	public void setSurrendercylinder(SurrenderCylinder surrendercylinder) {
		this.surrendercylinder = surrendercylinder;
	}

	@Override
	public String toString() {
		return "Cylinder [cylinderTypeId=" + cylinderTypeId + ", cylinderType=" + cylinderType + ", weight=" + weight
				+ ", price=" + price + ", customer=" + customer + ", surrendercylinder=" + surrendercylinder + "]";
	}

	
	
	
}
