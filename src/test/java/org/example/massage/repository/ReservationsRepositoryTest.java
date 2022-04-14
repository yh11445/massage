package org.example.massage.repository;

import org.example.massage.domain.Massages;
import org.example.massage.domain.Reservations;
import org.example.massage.domain.Role;
import org.example.massage.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationsRepositoryTest {

	@Autowired
	ReservationsRepository reservationsRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	MassagesRepository massagesRepository;

	@Test
	public void addReservation_test() {
		// given
		Reservations reservations = Reservations.builder()
				.user(givenUser())
				.massage(givenMassage())
				.status("1")
				.date(LocalDate.now())
				.startTime(LocalTime.of(10, 0))
				.endTime(LocalTime.of(11, 0))
				.totalTime(60)
				.description("어깨, 등이 뻐근해요")
				.build();

		// when
		reservationsRepository.save(reservations);

		// then
		System.out.println(reservationsRepository.findAll().get(0).getDescription());
	}

	private Users givenUser() {
		String email = "yh11445@naver.com";
		String pwd = "1234";
		String name = "kim";
		String tel = "01090091641";
		Role role = Role.USER;

		return usersRepository.save(Users.builder()
				.email(email)
				.pwd(pwd)
				.name(name)
				.tel(tel)
				.role(role)
				.build());
	}

	private Massages givenMassage() {
		String type = "A";
		Integer time = 60;
		Integer price = 100000;

		return massagesRepository.save(Massages.builder()
				.type(type)
				.time(time)
				.price(price)
				.build());
	}

	private void givenReservations(Users user, Massages massage) {
		Reservations reservations = Reservations.builder()
				.user(user)
				.massage(massage)
				.status("1")
				.date(LocalDate.now())
				.startTime(LocalTime.of(10, 0))
				.endTime(LocalTime.of(11, 0))
				.totalTime(60)
				.description("어깨, 등이 뻐근해요")
				.build();

		reservationsRepository.save(reservations);

		reservations = Reservations.builder()
				.user(user)
				.massage(massage)
				.status("1")
				.date(LocalDate.of(2022, 1, 13))
				.startTime(LocalTime.of(13, 0))
				.endTime(LocalTime.of(14, 0))
				.totalTime(60)
				.description("어깨, 등이 뻐근해요22")
				.build();

		reservationsRepository.save(reservations);
	}

	@Test
	public void getReservationsByUserId() {
		// given
		Users user = givenUser();
		Massages massage = givenMassage();
		givenReservations(user, massage);

		// when
		List<Reservations> reservationsList = reservationsRepository.findByUserId(user.getId());

		// then
		reservationsList.forEach(System.out::println);
	}

}