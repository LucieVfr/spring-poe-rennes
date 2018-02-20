package poe.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationDelegateTests {
	
	@Autowired
	UserManagerService userManagerService;

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void checkLoginIsNotToto() {
		User userToto = userManagerService.signup("toto", "MotDePasseDeToto");
		assertThat(userToto.getId()).isNull();	
		
		User userTata = userManagerService.signup("tata", "MotDePasseDeToto");
		assertThat(userTata.getId()).isNull();	
		
		User userTiti = userManagerService.signup("titi", "MotDePasseDeToto");
		assertThat(userTiti.getId()).isNull();	
		
		User userTutu = userManagerService.signup("tutu", "MotDePasseDeToto");
		assertThat(userTutu.getId()).isNotNull();	
	}
	
	@Test
	public void checkLoginSize() {
		User userShort = userManagerService.signup("Bob", "MotDePasseDeToto");
		assertThat(userShort.getId()).isNull();	
		
		User userLong = userManagerService.signup("Lalalalalala", "MotDePasseDeToto");
		assertThat(userLong.getId()).isNull();	
		
		User userCorrect = userManagerService.signup("Tititi", "MotDePasseDeToto");
		assertThat(userCorrect.getId()).isNotNull();	
				
	}

}
