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
import org.springframework.web.bind.annotation.RequestParam;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.services.SiteService;
import com.shelby.project.validator.CandValidator;
import com.shelby.project.validator.ConstValidator;

@Controller
public class SiteController {
	private SiteService ss;
	private CandValidator candV;
	private ConstValidator constV;

	public SiteController(SiteService ss, CandValidator candV, ConstValidator constV) {
		this.ss = ss;
		this.candV = candV;
		this.constV = constV;
	}

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("candidate") Candidate candidate,
			@Valid @ModelAttribute("constit") Constit constit) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration/candidate")
	public String registration(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result, Model model,
			HttpSession session) {
		candV.validate(candidate, result);
		if (result.hasErrors()) {
			model.addAttribute("constit", new Constit());
			return "registrationPage.jsp";
		}
		ss.saveWithCandRole(candidate);
		return "redirect:/login";
	}

	@PostMapping("/registration/constituent")
	public String registration(@Valid @ModelAttribute("constit") Constit constit, BindingResult result, Model model,
			HttpSession session) {
		constV.validate(constit, result);

		if (result.hasErrors()) {
			model.addAttribute("candidate", new Candidate());
			return "registrationPage.jsp";
		}
		ss.saveWithConstRole(constit);
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "login.jsp";
	}
	
	@RequestMapping("/")
	public String landing(Model model) {
		return "landing.jsp";
	}

	@RequestMapping(value = { "/home" })
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		Candidate cand = ss.findCandByUsername(username);
		Constit constit = ss.findConstByEmail(username);
		if (cand != null) {
			model.addAttribute("currentUser", cand);
		} else if (constit != null) {
			model.addAttribute("currentUser", constit);
		}
		return "homePage.jsp";
	}
	
	@RequestMapping("/cand")
    public String candPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", ss.findCandByUsername(username));
        return "adminPage.jsp";
    }

}
