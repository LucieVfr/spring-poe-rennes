package poe.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.TrajetManagerService;
import poe.spring.service.UserManagerService;

	@Controller
	@RequestMapping("/formulaireTrajet")
public class TrajetPageController {

		@Autowired
		TrajetManagerService trajetManagerService;
		
		@Autowired
		UserManagerService userManagerService;
		
		@Autowired
    	UserRepository userReposiroty;
		
	    @GetMapping
	    public String home(Model model) {
	    	List<User> users = (List<User>) userManagerService.lister();
			model.addAttribute("users", users);
	    	
	        return "formulaireTrajet";
	    }

	    @PostMapping
	    public String save(String stringIdConducteur, String villeDepart, String villeArrivee, @DateTimeFormat(pattern="yyyy-MM-dd")Date date, int prix, int nombrePlace, RedirectAttributes attr) {
	    	long idConducteur = Long.parseLong(stringIdConducteur);
	    	User conducteur = userReposiroty.findOne(idConducteur);
	    	
	    	attr.addAttribute("conducteur", conducteur);
			attr.addAttribute("villeDepart", villeDepart);
			attr.addAttribute("villeArrivee", villeArrivee);
			attr.addAttribute("date", date);
			attr.addAttribute("prix", prix);
			attr.addAttribute("nombrePlace", nombrePlace);
			trajetManagerService.save(conducteur, villeDepart, villeArrivee, date, prix, nombrePlace);
	        
	        
	        return "redirect:/formulaireTrajet/trajetValide";
	    }

	    @GetMapping("/trajetValide")
	    public String success() {
	        return "trajetValide";
	    }
	
}
