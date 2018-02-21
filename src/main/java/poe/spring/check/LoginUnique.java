package poe.spring.check;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class LoginUnique {

	@Autowired
	UserRepository userReposiroty;
	
	public boolean loginUnique(String loginTest) {
		Boolean loginUnique = true;

		List<User> users = new ArrayList<User>();
		
		users =	(List<User>) userReposiroty.findAll();
		
		for (User user : users) {
			String loginExistant = user.getLogin();
			
			if (loginExistant.equals(loginTest)) {
				loginUnique = false;
			}			
		}		
		return loginUnique;
		}
	}
