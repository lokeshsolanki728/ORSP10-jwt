package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PaymentDTO;

/**
 * Contains User form elements and their declarative input validations.
 * 
 *Lokesh Solanki
 */

public class PaymentForm {

	private Long id;

	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "customerName is required")
	private String customerName;
	@NotEmpty(message = "paymentMode is required")
	private String paymentMode;
	@NotEmpty(message = "paymentStatus is required")
	private String paymentStatus;
	@NotEmpty(message = "loginId is required")
	private String loginId;
	@NotEmpty(message = "password is required")
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

	public <T extends PaymentDTO> T initDTO(T dto) {

		if (id != null && id > 0) {
			dto.setId(id)
;

		} else {

			dto.setId(null);
		}
		return dto;
	}

	
	public PaymentDTO getDTO() {

	 PaymentDTO dto = initDTO(new  PaymentDTO()) ;
	 dto.setCustomerName(customerName);
	 dto.setPaymentMode(paymentMode);
	 dto.setPaymentStatus(paymentStatus);
	 dto.setLoginId(loginId);
	 dto.setPassword(password);

	 return dto;
	}
}