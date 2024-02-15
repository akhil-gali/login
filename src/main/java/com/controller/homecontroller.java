package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Admin;
import com.demo.Adminrepository;
import com.demo.Registration;
import com.demo.Remedy;
import com.demo.Remedyassigned;
import com.demo.Remedyassignedrepository;
import com.demo.Remedyrepository;
import com.demo.SupportAnalyst;
import com.demo.SupportAnalystRepository;
import com.demo.home;
import com.demo.logindetails;
import com.service.AdminService;
import com.service.Remedyservice;

@Controller
public class homecontroller {
	@Autowired
	private Adminrepository repository3;
	@Autowired
	private AdminService service3;
	@Autowired
	private Remedyservice service;
	@Autowired
	private Remedyrepository repository1;
	@Autowired
	private SupportAnalystRepository repository4;
	@Autowired
	private Remedyassignedrepository repository5;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String show9(ModelMap model, @ModelAttribute("home") home home) {
		String user1 = "RemedyProject";
		model.put("user", user1);
		return "home";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String show1(ModelMap model, @ModelAttribute("admin") Admin admin) {
		String user1 = "RemedyProject";
		model.put("user", user1);
		return "adminlogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String show10(ModelMap model, @Valid @ModelAttribute("admin") Admin Admin, BindingResult result) {
		service3.load2();
		service3.validate(Admin, result);
		if (result.hasErrors()) {
			return "adminlogin";
		} else if (service3.load(Admin)) {
			return "welcomeadmin";
		} else {
			System.out.println("hello");
			return "adminlogin";
		}
	}

	@ModelAttribute("adminremedy")
	public List<Remedy> remedy() {
		List<Remedy> list = new ArrayList<>();
		for (Iterator<Remedy> iterator = repository1.findAll().iterator(); iterator.hasNext();) {
			Remedy remedy1 = iterator.next();
			list.add(remedy1);
		}
		return list;
	}

	@RequestMapping(value = "/delete-remedy", method = RequestMethod.GET)
	public String deleteremedy(@RequestParam int id, @RequestParam String status,ModelMap model) {
		Remedy remedy = repository1.findById(id).get();
		repository1.delete(remedy);
		model.put("remedydelete", "Remedy is Deleted");
		return "welcomeadmin";
	}

	@RequestMapping(value = "/Assign-remedy", method = RequestMethod.GET)
	public String assignremedy(@RequestParam int id, ModelMap model, @RequestParam String status) {

		Remedy remedy = repository1.findById(id).get();
		if (status.equals("closed")) {
			model.put("remedydelete", "Remedy is Deleted");
			repository1.delete(remedy);
		} else {

			model.put("id", remedy.getRemedy_id());
			model.put("status", remedy.getStatus());
			return "welcome";
		}
		return null;
	}

	@RequestMapping(value = "/delete-analyst", method = RequestMethod.GET)
	public String deleteanalyst(@RequestParam int SupportAnalyst_id,ModelMap model) {
		SupportAnalyst SupportAnalyst = repository4.findById(SupportAnalyst_id).get();
		repository4.delete(SupportAnalyst);
		model.put("analystdelete", "Analyst is Deleted");
		return "/welcomeadmin";
	}

	@RequestMapping(value = "/assign-analyst", method = RequestMethod.GET)
	public String assignananalyst(@RequestParam int remedy_id, ModelMap model, @RequestParam String status,
			@RequestParam int SupportAnalyst_id) {
		Remedy remedy = repository1.findById(remedy_id).get();
		if (status.equals("closed")) {
			model.put("remedydelete", "Remedy is Deleted");
			repository1.delete(remedy);
		}else {
		model.put("Remedysend", "Remedy is assigned to SuportAnalyst");
		remedy.setStatus(status);
		remedy.setSupport_id(SupportAnalyst_id);
		model.addAttribute("support_id",SupportAnalyst_id);
		service.loadassign(remedy);
		return "welcomeadmin";
	}
		return null;
	}

	@ModelAttribute("analyst")
	public List<SupportAnalyst> analyst() {
		List<SupportAnalyst> list = new ArrayList<>();
		for (Iterator<SupportAnalyst> iterator = repository4.findAll().iterator(); iterator.hasNext();) {
			SupportAnalyst SupportAnalyst1 = iterator.next();
			list.add(SupportAnalyst1);
		}
		return list;
	}

	@ModelAttribute("Remedyassigned")
	public List<Remedyassigned> remedyassigned() {
		List<Remedyassigned> list = new ArrayList<>();
		for (Iterator<Remedyassigned> iterator = repository5.findAll().iterator(); iterator.hasNext();) {
			Remedyassigned Remedyassigned = iterator.next();
			list.add(Remedyassigned);
		}
		return list;
	}
}
