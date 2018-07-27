package com.shelby.project.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shelby.project.models.Candidate;
import com.shelby.project.models.Constit;
import com.shelby.project.models.Issue;
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
	public String registration(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result,
			Model model, HttpSession session) {
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

	@RequestMapping(value = { "/userLanding" })
	public String home(Principal principal, Model model) {
		model.addAttribute("newIssue", new Issue());
		String username = principal.getName();
		Candidate cand = ss.findCandByUsername(username);
		Constit constit = ss.findConstByusername(username);
		if (cand != null) {
			model.addAttribute("currentUser", cand);
			return "candLandingPage.jsp";
		} else if (constit != null) {
			System.out.println("constit issues: " + constit.getRaisedIssues());
			model.addAttribute("issues", constit.getRaisedIssues());
			model.addAttribute("currentUser", constit);
			return "constLanding.jsp";
		}
		return "landing";
	}

	@RequestMapping("/cand")
	public String candPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", ss.findCandByUsername(username));
		return "adminPage.jsp";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String receiveFile(@RequestParam("file") MultipartFile file, Principal principal)
			throws IOException {
		System.out.println("in upload");
		 String UPLOADED_FOLDER = "/home/smirziteh/DOJO/java_stack/Project/CtoC/ctoc/src/main/resources/static/images/";
		if (!file.isEmpty()) {
//			System.out.println("File" + description);
		}
		try {
			
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			System.out.println("file: " + file.getOriginalFilename());
			String filePath = "images/"+ file.getOriginalFilename();
			String username = principal.getName();
			System.out.println("filepath: " + filePath);
			Constit constit = ss.findConstByusername(username);
			if(constit == null) {
				Candidate candid = ss.findCandByUsername(username);
				ss.savePicPath(filePath, candid);
			} else {
				ss.savePicPath(filePath, constit);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/userLanding";
	}
	
	@PostMapping("/addIssue")
	public String addIssue(@Valid @ModelAttribute("newIssue") Issue issue, BindingResult br, Model model, Principal principal) {
		if(br.hasErrors()) {
			return "constitLanding.jsp";
		} else {
			ss.saveNewIssue(principal, issue);
			return "redirect:/userLanding";
		}
	}
	
	
	
	
	
	
	

}
