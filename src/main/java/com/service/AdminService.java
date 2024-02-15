package com.service;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.Admin;
import com.demo.Adminrepository;

@Service
public class AdminService implements Validator {

	@Autowired
	private Adminrepository repository3;

	public boolean load(Admin Admin) {
		System.out.println(Admin.getUsername());
		Admin admin = repository3.findByUsername(Admin.getUsername());
		if (admin.getPassword().equals(Admin.getPassword())) {
			return true;
		}
		return false;
	}

	public void load2() {
		Admin admin = new Admin();
		admin.setUsername("user");
		admin.setPassword("password");
		repository3.deleteAll();
		repository3.save(admin);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Admin.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Admin bean = (Admin) target;
		if (bean.getUsername().length() <= 0) {
			errors.rejectValue("username", "", "Adminname cannot be blank");
		}
		if (bean.getPassword().length() <= 0) {
			errors.rejectValue("password", "", "Password cannot be blank");
		} else if (bean.getUsername().length() > 0) {
			for (Iterator<Admin> iterator = repository3.findAll().iterator(); iterator.hasNext();) {
				Admin Admin = iterator.next();
				if (!(bean.getPassword().contains(Admin.getPassword()))) {
					errors.rejectValue("password", "",
							"User Name or Password does not match to the Admin name.so please enter correct User name and password");
				}
			}
		}
	}

}
