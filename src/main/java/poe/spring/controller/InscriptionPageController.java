package poe.spring.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.User;
import poe.spring.exception.DuplicateLoginBusinessException;
import poe.spring.form.LoginForm;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/inscription")
public class InscriptionPageController {
	
	private static Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	UserManagerService userManagerService;

	@GetMapping
	public String inscription() {
		return "inscription";
	}
	
	
	@PostMapping
	public String inscription(@Valid LoginForm form,
					   BindingResult bindingResult,
					   RedirectAttributes attr,
					   Model model) {

		log.info("ajout d'un utilisateur login: {0}", form.getLogin());

		if (bindingResult.hasErrors()) {//
			return "signup";
		}


		try {
			userManagerService.signup(form.getLogin(), form.getPassword());
		} catch (DuplicateLoginBusinessException e) {
			model.addAttribute("error", "Ce login est déjà utilisé!");
			return "signup";
		}
		attr.addAttribute("userName", form.getLogin());
		return "redirect:/inscription/validation";
}
	
	
	

//	@PostMapping
//	public String inscription(String login, String password, RedirectAttributes attr, Model model) {
//		System.out.println("Login: " + login + "\nMot de passe: " + password);
//
//		attr.addAttribute("login", login);
//		attr.addAttribute("password", password);
//		
//		User user = userManagerService.signup(login, password);
//		
//		//User user = userManagerService.chercherLog(login);
//		if (user.getId()!= null) {
//		return "redirect:/inscription/validation";
//		}
//		else {
//		model.addAttribute("message", "Votre login n'est pas correct");
//		return "redirect:/inscription";
//		}
//		
//	}

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
