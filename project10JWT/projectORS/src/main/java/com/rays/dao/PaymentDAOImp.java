package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.PaymentDTO;

@Repository
public class PaymentDAOImp implements PaymentDAOInt {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public long add(PaymentDTO dto) {
		em.persist(dto);
		return dto.getId(); 
	}

	@Override
	public PaymentDTO update(PaymentDTO dto) {
		return em.merge(dto);
	
	}

	@Override
	public PaymentDTO findBYpk(Long id) {
		
		PaymentDTO dto = em.find(PaymentDTO.class, id);
		
		return dto;
	}

	@Override
	public void delete(PaymentDTO dto) {
		em.remove(dto);
				
	}

	@Override
	public List search(PaymentDTO dto,  int pageNo, int pageSize) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<PaymentDTO> cq =builder.createQuery(PaymentDTO.class) ;
		
		Root<PaymentDTO> qroot = cq.from(PaymentDTO.class);
		
		List<Predicate> predicateList = new ArrayList<Predicate>();
		
		if (dto != null) {

			if (dto.getCustomerName() != null && dto.getCustomerName().length() > 0) {
				predicateList.add(builder.like(qroot.get("customerName"), dto.getCustomerName() + "%"));
			}
		

			if (dto.getPaymentMode() != null && dto.getPaymentMode().length() > 0) {
				predicateList.add(builder.like(qroot.get("paymentMode"), dto.getPaymentMode() + "%"));
			}
			
			if (dto.getPaymentStatus() !=null && dto.getPaymentStatus().length() > 0) {
				predicateList.add(builder.like(qroot.get("paymentStatus"), dto.getPaymentStatus() + "%"));
				
			}
			
			if (dto.getLoginId() !=null && dto.getLoginId().length() > 0) {
				predicateList.add(builder.like(qroot.get("loginId"), dto.getLoginId() + "%"));
				
			}

			if (dto.getPassword() !=null && dto.getPassword().length() > 0) {
				predicateList.add(builder.like(qroot.get("password"), dto.getPassword() + "%"));
				
			}

		}
		
		cq.where(predicateList.toArray(new Predicate [predicateList.size()]));
		
		TypedQuery<PaymentDTO> query = em.createQuery(cq);
		
		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		
		List<PaymentDTO> list = query.getResultList();
		
		
		return list;
	}

	@Override
	public PaymentDTO findByUniquekey(String attribute, Object value) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<PaymentDTO> cq = builder.createQuery(PaymentDTO.class);
		
		Root<PaymentDTO> qroot = cq.from(PaymentDTO.class);
		
		Predicate condition = builder.equal(qroot.get(attribute),value);
		
		cq.where(condition);
		
		TypedQuery<PaymentDTO> queery = em.createQuery(cq);
		
		List<PaymentDTO> list = queery.getResultList();
		
		PaymentDTO dto = null;
		
		if (list.size() > 0) {
			
			dto = list.get(0);
		}
		
		return dto;
	}


	

}
