package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.Registration;
import com.demo.RegistrationRepository;
import com.demo.Remedy;
import com.demo.Remedyassigned;
import com.demo.Remedyassignedrepository;
import com.demo.Remedyrepository;

@Service
public class Remedyservice implements Validator {
	@Autowired
	private RegistrationRepository repository2;
	@Autowired
	private Remedyrepository repository1;
	@Autowired
	private Remedyassignedrepository repository3;

	public List<Remedy> remedy() {
		List<Remedy> list = repository1.findAll();
		return list;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Remedy.class.equals(clazz);
	}
	public Remedyassigned loadassign(Remedy remedy) {
		Remedy remedy2 = repository1.findById(remedy.getRemedy_id()).get();
		Remedyassigned Remedyassigned=new Remedyassigned();
		Remedyassigned.setRemedy_id(remedy2.getRemedy_id());
		Remedyassigned.setRemedy_number(remedy2.getRemedy_number());
		Remedyassigned.setRemedyselect(remedy2.getRemedyselect());
		Remedyassigned.setSeat_no(remedy2.getSeat_no());
		Remedyassigned.setIp_address(remedy2.getIp_address());
		Remedyassigned.setMobilenumber(remedy2.getMobilenumber());
		Remedyassigned.setPc_number(remedy2.getPc_number());
		Remedyassigned.setStatement(remedy2.getStatement());
		Remedyassigned.setUser_id(remedy2.getUser_id());
		Remedyassigned.setStatus(remedy2.getStatus());
		Remedyassigned.setSupport_id(remedy2.getSupport_id());
		repository3.save(Remedyassigned);
		return Remedyassigned;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Remedy bean = (Remedy) target;
		if(bean.getStatement().length()==0) {
			errors.rejectValue("seat_no", "", "Please type your problem Statement");
		}
		if (bean.getSeat_no().length() == 0) {
			errors.rejectValue("seat_no", "", "Please type your seat number");
		}
		if (bean.getPc_number().length() == 0) {
			errors.rejectValue("pc_number", "", "Please type your PC Number");
		}
		if (bean.getIp_address().length() == 0) {
			errors.rejectValue("ip_address", "", "Please type Ip Address");
		}
		if (bean.getMobilenumber().length() > 0) {
			if (bean.getMobilenumber().length() < 10) {
				errors.rejectValue("mobilenumber", "", "Contactnumber need to be 10 numbers");
			} else if (!(bean.getMobilenumber().matches("[0-9]"))) {
				errors.rejectValue("mobilenumber", "", "Contactnumber need to be numbers");
			}
		}
	}

}
