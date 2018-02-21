package poe.spring.check;

import org.springframework.stereotype.Service;

@Service
public class LoginCreationDelegate {



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
		if ("toto".equals(login) || "tata".equals(login) || "titi".equals(login) ) {
			loginAccepted = false;
		}
		return loginAccepted;
	}
}
