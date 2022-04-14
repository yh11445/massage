package org.example.massage.service.users;

import junit.framework.TestCase;
import org.example.massage.domain.Role;
import org.example.massage.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;

	@Test
	public void addUserTest() {
		// given
		Users user = Users.builder()
				.email("yh11445@gmail.com")
				.pwd("1234")
				.name("kimyh")
				.tel("01090091641")
				.role(Role.USER)
				.build();

		// when
		Users user2 = usersService.addUser(user);

//		System.out.println(user2);

		// then
		assertThat(user2.getEmail()).isEqualTo("yh11445@gmail.com");
	}

}