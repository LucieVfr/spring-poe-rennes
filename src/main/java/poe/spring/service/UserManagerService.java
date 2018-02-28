package poe.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import poe.spring.check.LoginCreationDelegate;
import poe.spring.check.LoginUnique;
import poe.spring.domain.User;
import poe.spring.exception.DuplicateLoginBusinessException;
import poe.spring.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import poe.spring.Application;
import poe.spring.service.UserManagerService;

import javax.servlet.http.HttpServletResponse;


@Service



public class UserManagerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserManagerService.class);
	
	@Autowired
	UserRepository userReposiroty;

	@Autowired
	LoginUnique test;

	@Autowired
	LoginCreationDelegate test2et3;
	
	
	
	
	private static Logger log = LoggerFactory.getLogger(UserManagerService.class);


	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	public void signup(String login, String password) throws DuplicateLoginBusinessException {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
        userRepository.save(user);

        inMemoryUserDetailsManager.createUser(new org.springframework.security.core.userdetails.User(user.getLogin(),
        		user.getPassword(), (Collection<? extends GrantedAuthority>) new ArrayList<GrantedAuthority>()));
		
		
		//User user = null;
		// on vérifie que le login n'est pas déjà utilisé
//		if (userRepository.findByLogin(login) == null) {
//			user = new User();
//			user.setLogin(login);
//			user.setPassword(password);
//			userRepository.save(user);
//		} else {
//			throw new DuplicateLoginBusinessException();
//		}
		//return user;
}

//	public User signup(String login, String password) {
//		User user = new User();
//
//		user.setLogin(login);
//		user.setPassword(password);
//
//		Boolean testLoginUnique = test.loginUnique(login);
//		Boolean test2 = test2et3.loginSize(login);
//		Boolean test3 = test2et3.loginAccepted(login);
//
//		if (testLoginUnique) {
//			if (test2) {
//				if (test3) {
//					userReposiroty.save(user);
//				} else {
//					LOG.info("INFO : Votre login est ridicule, ahahah, faut faire mieux, désole!");
//					LOG.debug("DEBUG : Votre login est ridicule, ahahah, faut faire mieux, désole!");
//					LOG.warn("WARN : Votre login est ridicule, ahahah, faut faire mieux, désole!");
//					LOG.error("ERROR : Votre login est ridicule, ahahah, faut faire mieux, désole!");
//					LOG.trace("TRACE : Votre login est ridicule, ahahah, faut faire mieux, désole!");
//				}
//			} else {
//				LOG.info("Le login n'est pas entre 4 et 10 caractères, merci de modifier cela!");
//			}
//		} else {
//			LOG.info("Le login existe déjà dans la base de donnée, il faudrait en choisir un autre.");
//		}
//
//		return user;
//	}

	public List<User> lister() {
		return (List<User>) userReposiroty.findAll();
	}

	public void delete(long id) {
		userReposiroty.delete(id);

	}

	public void update(Long id, String login) {
		User user = userReposiroty.findOne(id);
		user.setLogin(login);
		userReposiroty.save(user);
	}

	public User chercher(Long id) {
		return userReposiroty.findOne(id);
	}

	
	public User chercherLog(String login) {
		User user = null;
		List<User> users = (List<User>) userReposiroty.findAll();
		for (User userListe : users) {
			if (userListe.getLogin().equals(login)) {
				user = userListe;
			}
		}		
		return user;
	}

}
