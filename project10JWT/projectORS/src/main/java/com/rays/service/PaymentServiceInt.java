package com.rays.service;

import java.util.List;
import com.rays.dto.PaymentDTO;


/**
 * 
 * User Service interface.
 *Lokesh Solanki 
 * 
 */

public interface PaymentServiceInt {
	

	public long register(PaymentDTO dto);

	public PaymentDTO update(PaymentDTO dto);

	public PaymentDTO delete(PaymentDTO dto);

	public PaymentDTO findById(Long pk);

	public List search(PaymentDTO dto, int pageNO, int pageSize);

	public PaymentDTO authenticate(String loginId, String password);


	
	
}
