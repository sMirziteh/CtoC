package com.shelby.project.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;

@Controller
public class SiteController {

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("candidate") Candidate candidate, @Valid @ModelAttribute("constit") Constit constit) {
		return "registrationPage.jsp";
	}
}
