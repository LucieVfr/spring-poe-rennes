package poe.spring.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.repository.UserRepository;

@Service
public class LoginCreationDelegate {

	@Autowired
	UserRepository userReposiroty;

	public boolean loginSize(String login) {
		Boolean loginSizeCorrect = false;

		int taille = login.length();
		if (taille > 3 & taille < 11) {
			loginSizeCorrect = true;
		}
		return loginSizeCorrect;
	}

	public boolean loginAccepted(String login) {
		Boolean loginAccepted = true;
		if ("toto".equals(login) == true || "tata".equals(login) == true || "titi".equals(login) == true) {
			loginAccepted = false;
		}
		return loginAccepted;
	}
}
