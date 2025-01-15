package com.rays.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.PaymentDTO;
import com.rays.form.LoginForm;
import com.rays.form.PaymentForm;
import com.rays.service.PaymentServiceInt;
/**
 *Lokesh Solanki 
 *
 */
@RestController
@RequestMapping(value = "Payment")
public class PaymentCtl <T extends PaymentDTO , Y extends PaymentServiceInt> {
	
	@Value("${page.size}")
	private int pageSize = 0;
	
	@Autowired
	Y base ;
	
	@PostMapping("signup")
	public ORSResponse signup(@RequestBody @Valid PaymentForm form , BindingResult bindingResult) {
		
	//	ORSResponse res = new ORSResponse();
		ORSResponse res = validate(bindingResult);
		
		if(!res.isSuccess()) {
			return res;
		}
		
		PaymentDTO dto = new PaymentDTO();
		if(form != null) {
		
		dto.setCustomerName(form.getCustomerName());
		dto.setPaymentMode(form.getPaymentMode());
		dto.setPaymentStatus(form.getPaymentStatus());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		base.register(dto);
		
		if(dto != null) {
			res.addData(dto);
			res.addMessage("user registered successfully");
		
		}
		}
		return res;
		
	}
	
	@PostMapping("/update")
	public ORSResponse update (@RequestBody PaymentForm form) {
		
		ORSResponse res = new ORSResponse();
		PaymentDTO dto = new PaymentDTO();
		
		if(form != null) {
			
			dto.setId(form.getId());
			dto.setCustomerName(form.getCustomerName());
			dto.setPaymentMode(form.getPaymentMode());
			dto.setPaymentStatus(form.getPaymentStatus());
			dto.setLoginId(form.getLoginId());
			dto.setPassword(form.getPassword());
			base.update(dto);
			res.addMessage("user updated successfully");
			
		}else {
			res.addMessage("record not found");
		}
	
		return res;
		
	}
	
	@GetMapping("delete/{id}")
	public ORSResponse delete (@PathVariable long id ) {
		
		ORSResponse res = new ORSResponse();
		PaymentDTO dto = base.findById(id);
		
		if (dto != null) {
			
			base.delete(dto);
			res.addMessage("payment record is deleted");
			
		}else {
			res.addMessage("payment not found");
		}
		return res;
		
	}
	
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse();
		PaymentDTO dto = new PaymentDTO();
		List<DropdownList> list = base.search(dto, 0, 0);
		res.addResult("paymentList", list);
		return res;
	
	}
	
	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody PaymentForm form , @PathVariable int pageNo, PaymentDTO dto) {
		
//		ORSResponse res = new ORSResponse();
//		PaymentDTO dto = new PaymentDTO();
//		
//		dto.setCustomerName(form.getCustomerName());
//		List list = base.search(dto);
//		res.addData(list);
//		return res;
		

		ORSResponse res = new ORSResponse();
		System.out.println("search");

		dto.setCustomerName(form.getCustomerName());
		System.out.println("form " + form.getCustomerName());

		dto.setPaymentMode(form.getPaymentMode());
		dto.setPaymentStatus(form.getPaymentStatus());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		
//		List list = base.search(dto,pageNo,pageSize);
//		res.addData(list);

		res.addData(base.search(dto, pageNo, pageSize));

		List nextList = base.search(dto, pageNo + 1, pageSize);

		res.addResult("nextList", nextList.size());
		return res;

		
	}
	
	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		
		ORSResponse res = new ORSResponse();
		PaymentDTO dto = base.findById(id);
		res.addData(dto);
		
		return res;
		
	}
	
	public ORSResponse validate(BindingResult result) {
		
		ORSResponse res = new ORSResponse (true);
		
		if (result.hasErrors()) {
			res.setSuccess(false);
			
			Map<String , String> errors = new HashMap<String , String>();
			
			List<FieldError> list = result.getFieldErrors();
			list.forEach(e -> {
				errors.put(e.getField(), e.getDefaultMessage());
			});
		res.addInputErrors(errors);
	}
		return res;
	}
	
	
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form ,BindingResult BindingResult) {
		
		ORSResponse res = validate(BindingResult);
		
		if (!res.isSuccess()) {
			return res;
		}
		
		PaymentDTO dto = base.authenticate(form.getLoginId(),form.getPassword());
		
		if (dto != null) {
		res.addData(dto);
		res.addMessage("payment is valid");
	}else {
		res.addMessage("Invalid loginId & password");
		res.setSuccess(false);
	}
	return res;
	}
	
	

}
	
	

