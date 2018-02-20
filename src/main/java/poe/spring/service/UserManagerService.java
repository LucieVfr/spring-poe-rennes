package poe.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.check.LoginCreationDelegate;
import poe.spring.check.LoginUnique;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service // service Spring
public class UserManagerService {

	@Autowired
	UserRepository userReposiroty;

	@Autowired
	LoginUnique test;

	@Autowired
	LoginCreationDelegate test2et3;

	public User signup(String login, String password) {
		User user = new User();

		user.setLogin(login);
		user.setPassword(password);

		Boolean testLoginUnique = test.loginUnique(login);
		Boolean test2 = test2et3.loginSize(login);
		Boolean test3 = test2et3.loginAccepted(login);

		if (testLoginUnique) {
			if (test2) {
				if (test3) {
					userReposiroty.save(user);
				} else {
					System.out.println("Votre login est ridicule, ahahah, faut faire mieux, désole!");
				}
			} else {
				System.out.println("Le login n'est pas entre 4 et 10 caractères, merci de modifier cela!");
			}
		} else {
			System.out.println("Le login existe déjà dans la base de donnée, il faudrait en choisir un autre.");
		}

		return user;
	}

	public List<User> lister() {
		List<User> users = (List<User>) userReposiroty.findAll();
		return users;
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
		User user = userReposiroty.findOne(id);
		return user;
	}

}
