package com.rays.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * User POJO class. It is persistent object.
 * AuthorLokesh Solanki 
 */

@Entity
@Table(name = "ST_Payment")
public class PaymentDTO  {
	@Id
	@GeneratedValue(generator = "npk")
	@GenericGenerator(name = "npk",strategy = "native")
	@Column (name ="ID", unique = true, nullable = false)
	
	public long id ;
	
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getkey() {
		return id + " ";
	}
	
	@Column(name = "CustomerName" , length = 50)
	private String customerName;
	
	@Column( name = "PaymentMode" , length = 50)
	private String paymentMode;
	
	@Column( name = "PaymentStatus" , length = 50)
	private String paymentStatus;
	
	@Column(name = "LoginId" , length = 50)
	private String loginId;
	
	@Column(name = "password" , length = 50)
	private String password;
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}



	