package poe.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;

	@Autowired
	UserRepository userRepository;

	@Test
	public void checkUserCreation2() {
		String login = "jean";

		User createdUser = userManagerService.signup("jean", "secret");

		long createdUserId = createdUser.getId();
		User user = userRepository.findOne(createdUserId);

		assertThat(user).isNotNull();

		assertThat(user.getLogin()).isEqualTo(login);
	}


	@Test
	public void checkUserDeletion() {
		User createdUser = userManagerService.signup("Paul", "motDePasse");
		System.out
				.println(" User Login : " + createdUser.getLogin() + "\n User Password : " + createdUser.getPassword());

		assertThat(createdUser).isNotNull();

		Long id = createdUser.getId();
		userManagerService.delete(id);
		User user = userRepository.findOne(id);
		assertThat(user).isNull();

	}
}