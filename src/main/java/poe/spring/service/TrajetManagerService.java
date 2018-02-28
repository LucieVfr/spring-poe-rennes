package poe.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.Trajet;
import poe.spring.domain.User;
import poe.spring.repository.TrajetRepository;
import poe.spring.repository.UserRepository;

@Service
public class TrajetManagerService {
	

	@Autowired
	TrajetRepository trajetRepository;	
	
	@Autowired
	UserRepository userRepository;	
	
	@Autowired
	UserManagerService userManagerService;
		


	public Trajet save(User conducteur, String villeDepart, String villeArrivee, Date date, int prix, int nombrePlace) {
		Trajet trajet = new Trajet();
		
		
		
		
		trajet.setUser(conducteur);
		trajet.setVilleDepart(villeDepart);
		trajet.setVilleArrivee(villeArrivee);
		trajet.setDate(date);
		trajet.setPrix(prix);
		trajet.setNombrePlace(nombrePlace);
		System.out.println("Trajet enregistré");
		trajetRepository.save(trajet);
		
		return trajet;
	}
	

	public List<Trajet> lister() {
		List<Trajet> trajets = (List<Trajet>) trajetRepository.findAll();
		return trajets;
	}
	
	
	public List<Trajet> listerTrajetConducteur(Long id) {
		User user = userRepository.findOne(id);		
		List<Trajet> trajets = user.getTrajets();
		return trajets;
	}

	public void delete(long id) {
		trajetRepository.delete(id);

	}


	public Trajet chercher(Long id) {
		Trajet trajet = trajetRepository.findOne(id);
		return trajet;
	}
	

	public List<Trajet> search(String town) {
		List<Trajet> trajets = new ArrayList<>();

		if (town != null) {
			trajets = trajetRepository.findByVilleDepartLikeIgnoreCaseOrVilleArriveeLikeIgnoreCase("%" + town + "%", "%" + town + "%");
		} else {
			trajets = (List<Trajet>) trajetRepository.findAll();
		}

		return trajets;
	}




}
