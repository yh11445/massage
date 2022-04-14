package org.example.massage.repository;

import org.example.massage.domain.Role;
import org.example.massage.domain.Users;
import org.example.massage.repository.UsersRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

//    @After
    public void cleanup() {
        usersRepository.deleteAll();
    }

    @Test
    public void 사용자저장_조회() {
        //given
        String email = "yh11445@naver.com";
        String pwd = "1234";
        String name = "kim";
        String tel = "01090091641";
        Role role = Role.USER;

        usersRepository.save(Users.builder()
                .email(email)
                .pwd(pwd)
                .name(name)
                .tel(tel)
                .role(role)
                .build());

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users user = usersList.get(0);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getName()).isEqualTo(name);


    }
}
