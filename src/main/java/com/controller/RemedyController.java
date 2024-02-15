package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.Registration;
import com.demo.Remedy;
import com.demo.Remedyrepository;
import com.service.Remedyservice;

@Controller
public class RemedyController {
	@Autowired
	private Remedyservice service;
	@Autowired
	private Remedyrepository repository1;

	@RequestMapping(value = "/welcomeuser", method = RequestMethod.GET)
	public String show1(ModelMap model, @Valid @ModelAttribute("login") Remedy Registration) {
		return "welcomeuser";
	}

	@RequestMapping(value = "/welcomeuser", method = RequestMethod.POST)
	public String show3(ModelMap model, @Valid @ModelAttribute("login") Remedy Registration,
			BindingResult result) {
		service.validate(Registration, result);
		if (result.hasErrors()) {
			return "welcomeuser";
		} else {
			repository1.save(Registration);
			//service.load(Registration);
			model.put("remedy1", "Your Remedy is registered successfully");
			return "welcomeuser";
		}
	}

}
