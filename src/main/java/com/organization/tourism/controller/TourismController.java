package com.organization.tourism.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.organization.tourism.Service.TourismService;
import com.organization.tourism.entity.Search;
import com.organization.tourism.entity.Tourism;
import com.organization.tourism.entity.UserManage;

@Controller
@RequestMapping("/tourism")
public class TourismController {
	
	@Autowired
	private TourismService service;
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model theModel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null) {
		Tourism entry = new Tourism();
		theModel.addAttribute("entry", entry);
		return "tourism_add_form";
		}
		else 
			return "redirect:/tourism/login";
	}
	
	@GetMapping("/list")
	public String listAllEntries(Model theModel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null) {
		List<Tourism> list = service.listEntries();
		theModel.addAttribute("listOfEntries", list);
		return "tourism_display_list";
		}
		else
			return "redirect:/tourism/login";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("tourId") int id,Model themodel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null) {
		Tourism entry = service.getEntryById(id);
		themodel.addAttribute("entry", entry);
		return "tourism_add_form";
		}
		else
			return "redirect:/tourism/login";
	}
	
	@GetMapping("/showFormForDelete")
	public String showDeleteForm(@RequestParam("TourId") int id,HttpServletRequest request){
		if(request.getSession().getAttribute("username") != null){
		service.deleteEntry(id);
		return "redirect:/tourism/list";
		}
		else
			return "redirect:/tourism/login";
		
	}
	
	@GetMapping("/showFormForSearch")
	public String showSearch(Model themodel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null){
		Search search = new Search();
		themodel.addAttribute("formData", search);
		return "search";
		}
		else
			return "redirect:/tourism/login";
	}
	
	@PostMapping("/processSearch")
	public String processSearch(@ModelAttribute("formData") Search data,Model themodel) {
		List<Tourism> result = service.getResultList(data.getLocationA(), data.getLocationB());
		themodel.addAttribute("resultList",result);
		return "display_search";
	}
	
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("entry") Tourism entry, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "tourism_add_form";
		service.addEntry(entry);
		return "redirect:/tourism/list";
	}
	
	@GetMapping("/login")
	public String manageUser(Model themodel,HttpServletRequest request) {
		request.getSession(false);
		if(request.getSession().getAttribute("username") == null) {
		UserManage user = new UserManage();
		themodel.addAttribute("user", user);
		return "login_page";
		}
		else {
			request.getSession().invalidate();
			return "redirect:/";
		}
			
	}
	
	@PostMapping("/validate")
	public String validateUser(@ModelAttribute("user") UserManage user,Model model,HttpServletRequest request) {
		request.getSession(false);
		List<UserManage> userList = service.listOfUsers();
		int flag = 0;
		for(UserManage u: userList) {
			if((u.getUsername().equalsIgnoreCase(user.getUsername()))&&(u.getPassword().equalsIgnoreCase(user.getPassword())))
				flag = 1;
		}
		if(flag == 1) {
			request.getSession().setAttribute("username", user.getUsername());
			return "redirect:/tourism/list";
		}
		else {
			String err = "UserName or Password doesn't match";
			model.addAttribute("errorMsg", err);
			return "login_page";
		}
	}
}
