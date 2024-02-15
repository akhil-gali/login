package com.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.Registration;
import com.demo.RegistrationRepository;
import com.demo.Remedy;
import com.demo.Remedyrepository;
import com.demo.SupportAnalyst;
import com.demo.SupportAnalystRepository;
import com.demo.User;
import com.demo.UserRepository;
import com.demo.home;
import com.demo.homerepository;
import com.demo.logindetails;
import com.demo.logindetailsRepository;

@Service
public class logservice implements Validator {

	@Autowired
	private logindetailsRepository repository1;
	@Autowired
	private RegistrationRepository repository2;
	@Autowired
	private UserRepository repository3;
	@Autowired
	private SupportAnalystRepository repository4;
	@Autowired
	private homerepository repository5;
	@Autowired
	private Remedyrepository repository6;

	public boolean load(Registration log) {
		boolean Boolean = false;
		if (repository2.findByUsername(log.getUsername()) == null) {
			Boolean = false;
			// throw new UsernameNotFoundException("Username does not have account so please
			// register one account");
		} else {
			Registration Registration = repository2.findByUsername(log.getUsername());
			if (Registration.getPassword().equals(log.getPassword())) {
				logindetails logindetails = new logindetails();
				logindetails.setUsername(Registration.getUsername());
				logindetails.setPassword(Registration.getPassword());
				logindetails.setRole(Registration.getRole());
				home home = new home();
				home.setRole(Registration.getRole());
				repository5.save(home);
				System.out.println(Registration.getRole());
				if (Registration.getRole().equals("User")) {
					User user = new User();
					user.setUsername(Registration.getUsername());
					user.setPassword(Registration.getPassword());
					for (Iterator<com.demo.User> iterator = repository3.findAll().iterator(); iterator.hasNext();) {
						User user1 = iterator.next();
						if (user1.getUsername().equals(Registration.getUsername())) {
							repository3.delete(user1);
						}
					}
					repository3.save(user);
					// logservice logservice1=new logservice();
					// logservice1.update(log, user);
					
					
					/*Remedy remedy = new Remedy();
					remedy.setRemedyselect(Registration.getRemedyselect());
					remedy.setSeat_no(Registration.getSeat_no());
					remedy.setIp_address(Registration.getIp_address());
					if (Registration.getMobilenumber().length() == 0) {
						remedy.setMobilenumber(Registration.getContactnumber());
					} else {
						remedy.setMobilenumber(Registration.getMobilenumber());
					}
					remedy.setPc_number(Registration.getPc_number());
					remedy.setStatement(Registration.getStatement());
					remedy.setUser_id(user.getUser_id());
					remedy.setStatus(Registration.getStatus());
					repository2.updateUser_id(log.getRegistration_id(), user.getUser_id());
					repository6.save(remedy);*/

				} else if (Registration.getRole().equals("SupportAnalyst")) {
					SupportAnalyst SupportAnalyst = new SupportAnalyst();
					SupportAnalyst.setUsername(Registration.getUsername());
					SupportAnalyst.setPassword(Registration.getPassword());
					SupportAnalyst.setSupportlevel(Registration.getSupportlevel());
					repository4.save(SupportAnalyst);
				}

				for (Iterator<com.demo.logindetails> iterator = repository1.findAll().iterator(); iterator.hasNext();) {
					com.demo.logindetails logindetails2 = iterator.next();
					if (logindetails2.getUsername().equals(log.getUsername())) {
						repository1.delete(logindetails2);
					}
				}
				repository1.save(logindetails);
				Boolean = true;

			}
		}
		return Boolean;
	}
	public User loaduser(Registration log) {
		Registration Registration = repository2.findByUsername(log.getUsername());
		if (Registration.getPassword().equals(log.getPassword())) {
			if (Registration.getRole().equals("User")) {
				User user = new User();
				user.setUsername(Registration.getUsername());
				user.setPassword(Registration.getPassword());
				for (Iterator<com.demo.User> iterator = repository3.findAll().iterator(); iterator.hasNext();) {
					User user1 = iterator.next();
					if (user1.getUsername().equals(Registration.getUsername())) {
						repository3.delete(user1);
					}
				}
				repository3.save(user);
				return user;
		}
		}
		return null;
	}
	public SupportAnalyst loadsupport(Registration log) {
		Registration Registration = repository2.findByUsername(log.getUsername());
		if (Registration.getPassword().equals(log.getPassword())) {
			if (Registration.getRole().equals("SupportAnalyst")) {
				SupportAnalyst SupportAnalyst = new SupportAnalyst();
				SupportAnalyst.setUsername(Registration.getUsername());
				SupportAnalyst.setPassword(Registration.getPassword());
				SupportAnalyst.setSupportlevel(Registration.getSupportlevel());
				for (Iterator<com.demo.SupportAnalyst> iterator = repository4.findAll().iterator(); iterator.hasNext();) {
					SupportAnalyst user1 = iterator.next();
					if (user1.getUsername().equals(Registration.getUsername())) {
						repository4.delete(user1);
					}
				}
				repository4.save(SupportAnalyst);
				return SupportAnalyst;
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return logindetails.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Registration bean = (Registration) target;
		if (bean.getUsername().length() == 0) {
			errors.rejectValue("username", "", "User Name cannot be blank");
		} else if (bean.getUsername().length() > 0) {
			for (Iterator<Registration> iterator = repository2.findAll().iterator(); iterator.hasNext();) {
				Registration Registration = iterator.next();
				/*
				 * if (!(bean.getUsername().contains(Registration.getUsername()))) {
				 * errors.rejectValue("username", "", "User does not exits.So create Account");
				 * 
				 * }
				 */if (bean.getPassword().length() <= 0) {
					errors.rejectValue("password", "", "Password cannot be blank");
				} /*
					 * else if (!(bean.getPassword().contains(Registration.getPassword()))) {
					 * errors.rejectValue("password", "",
					 * "Password does not match for the given username .so please enter correct password"
					 * ); }
					 */
			}
		}

	}

}
