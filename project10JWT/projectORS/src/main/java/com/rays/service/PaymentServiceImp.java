package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PaymentDAOInt;
import com.rays.dao.UserDAOInt;
import com.rays.dto.PaymentDTO;
import com.rays.dto.UserDTO;

/**
 * 
 *Lokesh Solanki
 */
@Service
@Transactional
public class PaymentServiceImp <T extends PaymentDTO , F extends PaymentDAOInt> implements PaymentServiceInt{

	@Autowired
	F paym;
	
	@Override
	public long register(PaymentDTO dto) {
		
		return paym.add(dto);
	}
	
	@Override
	public PaymentDTO update(PaymentDTO dto) {
		paym.update(dto);
		return dto;
		
	}

	@Override
	public PaymentDTO delete(PaymentDTO dto) {
		
		 paym.delete(dto);
		 
		 return dto;
		
		
	}

	@Override
	public PaymentDTO findById(Long pk) {
		
		PaymentDTO dto = paym.findBYpk(pk);
		
		return dto;
	}

	@Override
	public List search(PaymentDTO dto ,int pageNO, int pageSize) {
		List list = paym.search(dto,pageNO,pageSize);
		return list;
	}

	@Override
	public PaymentDTO authenticate(String loginId, String password) {
		
		PaymentDTO dto = findByLoginId(loginId);
		
		if (dto != null) {
			
			if (password.equals(dto.getPassword())) {
				return dto;
			}
		}
	
		return null;
	}

	private PaymentDTO findByLoginId(String loginId) {
		
		return paym.findByUniquekey("loginId",loginId);
	}

	

	
}

	

