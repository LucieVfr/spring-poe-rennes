package poe.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/inscription")
public class InscriptionPageController {
	
	@Autowired
	UserManagerService userManagerService;

	@GetMapping
	public String inscription() {
		return "inscription";
	}

	@PostMapping
	public String inscription(String login, String password, RedirectAttributes attr, Model model) {
		System.out.println("Login: " + login + "\nMot de passe: " + password);

		attr.addAttribute("login", login);
		attr.addAttribute("password", password);
		
		User user = userManagerService.signup(login, password);
		
		//User user = userManagerService.chercherLog(login);
		if (user.getId()!= null) {
		return "redirect:/inscription/validation";
		}
		else {
		model.addAttribute("message", "Votre login n'est pas correct");
		return "redirect:/inscription";
		}
		
	}

	@GetMapping("/validation")
	public String success(String login, String password, Model model) {
		model.addAttribute("login", login);
		model.addAttribute("password", password);
		return "validation"; // validation.html
	}
	
	@GetMapping("/echec")
	public String echec(String login, Model model) {		
		model.addAttribute("login", login);
		return "echec"; // validation.html
	}
}
