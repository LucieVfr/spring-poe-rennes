
package poe.spring.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
		@Autowired
		UserManagerService userManagerService;
	
		@PostMapping		
		public User save(@RequestBody User user) {
			
			
			User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
			System.out.println("user id : " + savedUser.getLogin());
			return savedUser;
			
		}				
		@GetMapping(path = "/list")
		public List<User> lister() {
			List<User> users = userManagerService.lister();
			return users;
		}
		
		@GetMapping(path = "/one")
		public User chercher(Long id) {

			User user = userManagerService.chercher(id);
			//System.out.println(" User Login : " + user.getLogin() + "\n User Password : "  + user.getPassword());
			return user;
		}

			@GetMapping(path = "/oneLog")
			public User chercherLog(String login) {
			User user = userManagerService.chercherLog(login);
			return user;
		}


		
		@GetMapping(path = "/delete")
		public void delete(Long id) {
			userManagerService.delete(id);			
			}
		
		@PostMapping(path = "/update")
		public void update(Long id, String login) {			
			userManagerService.update(id, login);			
			}
}
