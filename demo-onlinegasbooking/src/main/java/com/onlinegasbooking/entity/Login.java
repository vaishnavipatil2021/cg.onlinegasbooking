package com.onlinegasbooking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "egas_login")
public class Login {
 
	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name="login_password",length=25)
	private String password;
	
	@Column(name="login_role",length=25)
	private String role;
	
	@Column(name="user_name",length=30)
	private String userName;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", referencedColumnName = "customer_id")
	private Customer customer = new Customer();
	
	public Login() {
		super();
	}

	public Login(Integer userId, String password, String role, String userName) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Login [userId=" + userId + ", password=" + password + ", role=" + role + ", userName=" + userName
				+ ", customer=" + customer + "]";
	}
	
	
	
}
