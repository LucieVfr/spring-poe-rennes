package poe.spring.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.Trajet;
import poe.spring.domain.User;
import poe.spring.repository.TrajetRepository;
import poe.spring.repository.UserRepository;
import poe.spring.service.TrajetManagerService;

@RestController
@RequestMapping("/api/trajet")
public class TrajetRestController {
	
		@Autowired
		TrajetManagerService trajetManagerService;
		
		@Autowired
		UserRepository userReposiroty;
		
		@Autowired
		TrajetRepository trajetRepository;
	
		@PostMapping		
		public Trajet save(@RequestBody Trajet trajet) {
			
			

			Trajet trajetSaved = trajetManagerService.save(trajet.getUser(), trajet.getVilleDepart(), trajet.getVilleArrivee(), trajet.getDate(), trajet.getPrix(), trajet.getNombrePlace());
			
			return trajetSaved;
			
		}
			
			@GetMapping(path = "/list")
			public List<Trajet> lister() {
				List<Trajet> trajets = trajetManagerService.lister();
				System.out.println("Je chercher a afficher la liste des trajets");
				return trajets;
			}
			
			@GetMapping(path = "/one")
			public Trajet chercher(Long id) {
			Trajet trajet = trajetManagerService.chercher(id);
			//System.out.println(" User Login : " + user.getLogin() + "\n User Password : "  + user.getPassword());
			return trajet;
		}
		
		@GetMapping(path = "/delete")
		public void delete(Long id) {
			trajetManagerService.delete(id);			
			}
		
		@GetMapping("/search/{town}")
		public List<Trajet> search(@PathVariable("town") String ville) {
			return trajetRepository.rechercherParVilleDepart('%' + ville + '%');
		}

}