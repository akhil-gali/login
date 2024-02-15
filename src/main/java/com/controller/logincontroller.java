package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Registration;
import com.demo.RegistrationRepository;
import com.demo.Remedy;
import com.demo.Remedyassigned;
import com.demo.SupportAnalyst;
import com.demo.User;
import com.demo.home;
import com.demo.homerepository;
import com.demo.logindetails;
import com.service.Registrationservice;
import com.service.Remedyservice;
import com.service.logservice;

@Controller
public class logincontroller {

	@Autowired
	private logservice service1;
	@Autowired
	private Registrationservice service2;
	@Autowired
	private homerepository repository5;
	@Autowired
	private RegistrationRepository repository2;
	@Autowired
	private Remedyservice service;
	@Autowired
	private homecontroller homecontroller;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String show1(ModelMap model, @ModelAttribute("login") Registration log) {
		String user1 = "RemedyProject";
		model.addAttribute("login", log);
		model.put("user", user1);
		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String show2(ModelMap model, @Valid @ModelAttribute("login") Registration log) {
		String user1 = "RemedyProject";
		model.put("user", user1);
		return "Registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String show(ModelMap model, @ModelAttribute("login") Registration log, BindingResult result) {
		String user1 = "RemedyProject";
		model.put("user", user1);
		service1.validate(log, result);
		if (result.hasErrors()) {
			return "login";
		} else if (service1.load(log)) {
			Registration Registration = repository2.findByUsername(log.getUsername());
			if (Registration.getRole().equals("User")) {
				User user = service1.loaduser(Registration);
				model.addAttribute("user", Registration.getUsername());
				model.addAttribute("user_id", user.getUser_id());
				// repository2.updateUser_id(Registration.getRegistration_id(),user.getUser_id());
				return "welcomeuser";
			} else {
				/*SupportAnalyst SupportAnalyst1 = service1.loadsupport(Registration);
				for (Iterator<Remedyassigned> iterator = homecontroller.remedyassigned().iterator(); iterator
						.hasNext();) {
					Remedyassigned remedyassigned = iterator.next();
					if (SupportAnalyst1.getSupportAnalyst_id() == remedyassigned.getSupport_id()) {
						return "welcomesupportanalyst";
					} else {
						return "welcomesupportanalyst";
					}*/
					return "welcomesupportanalyst";
				}
		} else {
			model.put("log", "USERNAME DOES NOT EXITS.SO CREATE NEW ACCOUNT");
			return "login";
		}
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String show3(ModelMap model, @Valid @ModelAttribute("login") Registration log1, BindingResult result) {
		String user1 = "Sai Kiran";
		model.put("user", user1);
		service2.validate(log1, result);
		if (result.hasErrors()) {
			return "Registration";
		} else {
			service2.load(log1);
			model.put("log", "Your Registration is successful so login with your username and password");

			return "login";
		}
	}

	@ModelAttribute("gender")
	public Map<String, String> buildState() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Male", "Male");
		map.put("Female ", "Female ");
		return map;
	}

	@ModelAttribute("role")
	public Map<String, String> buildState2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("User", "User");
		map.put("SupportAnalyst", "SupportAnalyst");
		return map;
	}

	@ModelAttribute("Supportlevel")
	public Map<String, String> buildState3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("L1", "L1");
		map.put("L2", "L2");
		map.put("L3", "L3");
		return map;
	}

	@ModelAttribute("remedy2")
	public Map<String, String> buildState4() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Network Leave Management Portal", "Network Leave Management Portal");
		map.put("Desktop", "Desktop");
		map.put("Laptop", "Laptop");
		map.put("Admin", "Admin");
		map.put("travel", "travel");
		return map;
	}

	@ModelAttribute("remedy3")
	public Map<String, String> buildState5() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Open", "Open");
		map.put("Wip", "Wip");
		map.put("Closed", "Closed");
		map.put("Reopen", "Reopen");
		map.put("travel", "travel");
		return map;
	}

}
