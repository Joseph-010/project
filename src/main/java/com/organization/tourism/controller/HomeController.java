package com.organization.tourism.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String displayWelcomePage(HttpServletRequest request) {
		request.getSession(true);
		return "welcome";
	}
}
