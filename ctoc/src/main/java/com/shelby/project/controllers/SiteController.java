package com.shelby.project.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.services.SiteService;

@Controller
public class SiteController {
	private SiteService ss;
	
	public SiteController(SiteService ss) {
		this.ss = ss;
	}

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("candidate") Candidate candidate,
			@Valid @ModelAttribute("constit") Constit constit) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration/candidate")
	public String registration(@Valid @ModelAttribute("candidate") Candidate c, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		ss.saveWithCandRole(c);
		return "redirect:/login";
	}

	@PostMapping("/registration/constituent")
	public String registration(@Valid @ModelAttribute("constit") Constit c, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		ss.saveWithConstRole(c);
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		Candidate cand = ss.findCandByUsername(username);
		Constit constit = ss.findConstByEmail(username);
		if(cand != null) {
			model.addAttribute("currentUser", cand);
		} else if(constit != null) {
			model.addAttribute("currentUser", constit);
		}
		return "homePage.jsp";
	}
	
	
	
	
	
}
