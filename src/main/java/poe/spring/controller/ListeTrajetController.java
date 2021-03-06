package poe.spring.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.Trajet;
import poe.spring.domain.User;
import poe.spring.repository.TrajetRepository;
import poe.spring.service.TrajetManagerService;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/listeTrajet")
public class ListeTrajetController {
	
	@Autowired
	UserManagerService userManagerService;
	
	@Autowired
	TrajetManagerService trajetManagerService;
	
	@Autowired
	TrajetRepository trajetRepository;
	
//	@GetMapping
//	public String list(@RequestParam(required=false) String villeDepart, @RequestParam(required=false) String stringIdConducteur, Model model) {
//		
//		List<Trajet> trajetsSel = trajetManagerService.lister();
//		
//		if(stringIdConducteur == "0") {
//			for (Trajet trajet : trajetsSel) {
//				if (trajet.getUser().equals(stringIdConducteur) == false) {
//					
//					trajetsSel.remove(trajet);
//				}
//			}
//			
//		}
		
//		List<Trajet> trajets = null;
//		if(stringIdConducteur == "0") {
//			trajets = (List<Trajet>) trajetManagerService.lister();
//		}
//		
//		else if (stringIdConducteur != "0") {	
//			long idConducteur = Long.parseLong(stringIdConducteur);		
//			trajets = trajetManagerService.listerTrajetConducteur(idConducteur);
//					
//		}
//		
//		
//		if (villeDepart != "0") {
//			trajets = (List<Trajet>) trajetManagerService.lister();
//				}			
//		 else {
//			 trajets =	trajetRepository.rechercherParVilleDepart('%' + villeDepart + '%');
//		}
//		
//		model.addAttribute("trajetsSel", trajetsSel);
//		
//		List<User> users = (List<User>) userManagerService.lister();
//		model.addAttribute("users", users);
//			
//		List<Trajet>trajets = (List<Trajet>) trajetManagerService.lister();
//		model.addAttribute("trajets", trajets);
//		
//		return "/listeTrajet";
	@GetMapping
	public String list(@RequestParam(required = false) Long stringIdConducteur, @RequestParam(required = false) String villeDepart, Model model) {

		List<Trajet> trajets = trajetManagerService.search(villeDepart);

		model.addAttribute("trajets", trajets);
		
		
		
		List<User> users = (List<User>) userManagerService.lister();
    	model.addAttribute("users", users);

		return "/listeTrajet";



	}
	
//	public List<Trajet> search(String town) {
//		List<Trajet> trajets = new ArrayList<>();
//
//		if (town != null) {
//			trajets = trajetRepository.findByVilleDepartLikeIgnoreCaseOrVilleArriveeLikeIgnoreCase("%" + town + "%", "%" + town + "%");
//		} else {
//			trajets = (List<Trajet>) trajetRepository.findAll();
//		}
//
//		return trajets;
//}
	
}
