package poe.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service // service Spring
public class UserManagerService {

	@Autowired
	UserRepository userReposiroty;

	public User signup(String login, String password) {
		User user = new User();
		user.setLogin(login);
		
		user.setPassword(password);
		userReposiroty.save(user);

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
