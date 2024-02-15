package com.service;

import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.Registration;
import com.demo.RegistrationRepository;
import com.demo.SupportAnalyst;
import com.demo.SupportAnalystRepository;
import com.demo.User;
import com.demo.UserRepository;
import com.demo.home;
import com.demo.homerepository;
import com.demo.logindetails;
import com.demo.logindetailsRepository;

@Service
public class Registrationservice implements Validator {
	@Autowired
	private RegistrationRepository repository2;
	@Autowired
	private logindetailsRepository repository1;
	
	
	public void load(Registration log) {	
		repository2.save(log);
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Registration.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Registration bean = (Registration) target;
		System.out.println(bean.getUsername().length());
		if (bean.getUsername().length() <= 0) {
			System.out.println(bean.getUsername().length());
			errors.rejectValue("username", "", "User Name cannot be blank");
		}
		else if (bean.getUsername().length() > 0) {
			for (Iterator<Registration> iterator = repository2.findAll().iterator(); iterator.hasNext();) {
				Registration registration = iterator.next();
				if (bean.getUsername().equals(registration.getUsername())) {
					errors.rejectValue("username", "", "Username is already exits");
					break;
				}
			}
		}
		if (bean.getFirstname().length() <= 0) {
			errors.rejectValue("Firstname", "", "Firstname cannot be blank");
		}
		if (bean.getLastname().length() <= 0) {
			errors.rejectValue("Lastname", "", "Lastname cannot be blank");
		}
		if (bean.getPassword().length() <= 0) {
			errors.rejectValue("password", "", "Password cannot be blank");
		}
		if (bean.getPassword().matches("^[a-zA-Z]{1,}[0-9]{1,}")) {
			errors.rejectValue("password", "",
					"Password need to have atleast 1 character,1 number,1 special character and total of 8 so please type again");
		}
		if (bean.getContactnumber().length() == 0) {
			errors.rejectValue("Contactnumber", "", "Contactnumber cannot be blank");
		}
		if (bean.getContactnumber().length() > 10 || bean.getContactnumber().length() < 10) {
			errors.rejectValue("Contactnumber", "", "Contactnumber need to be 10 numbers");
		}
		if (bean.getContactnumber().matches("[0-9]")) {
			errors.rejectValue("Contactnumber", "", "Contactnumber need to be numbers");
		}
		if (bean.getContactnumber().length() == 10) {
			for (Iterator<Registration> iterator = repository2.findAll().iterator(); iterator.hasNext();) {
				Registration registration = iterator.next();
				if (bean.getUsername().equals(registration.getContactnumber())) {
					errors.rejectValue("Contactnumber", "",
							"Contactnumber is already exits.So please login your account by pressing login button");
					break;
				}
			}
		}
		if (bean.getEmailId().length() <= 0) {
			errors.rejectValue("EmailId", "", "EmailId cannot be blank");
		}
		if (!(bean.getEmailId().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
			errors.rejectValue("EmailId", "", "EmailId need to have displayed pattern");
		} else {
			for (Iterator<Registration> iterator = repository2.findAll().iterator(); iterator.hasNext();) {
				Registration registration = iterator.next();
				if (bean.getUsername().equals(registration.getEmailId())) {
					errors.rejectValue("EmailId", "",
							"EmailId is already exits.So please login your account by pressing login button");
					break;
				}
			}
		}
	}

}
