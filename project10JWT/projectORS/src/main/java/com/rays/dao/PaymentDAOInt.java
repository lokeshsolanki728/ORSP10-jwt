package com.rays.dao;

import java.util.List;
import com.rays.dto.PaymentDTO;


/**
 * 
 *Lokesh Solanki
 */

public interface PaymentDAOInt  {
	
	public long add(PaymentDTO dto);

	public PaymentDTO update(PaymentDTO dto);

	public PaymentDTO findBYpk(Long pk);

	public void delete(PaymentDTO dto);

	public List search(PaymentDTO dto, int pageNO, int pageSize);

	public PaymentDTO findByUniquekey(String attribute, Object value);

}
