package org.example.massage.service.reservations;

import lombok.RequiredArgsConstructor;
import org.example.massage.domain.Massages;
import org.example.massage.domain.Reservations;
import org.example.massage.domain.Users;
import org.example.massage.repository.ReservationsRepository;
import org.example.massage.service.massages.MassagesService;
import org.example.massage.service.users.UsersService;
import org.example.massage.web.dto.ReservationAddRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationsService {
	private final ReservationsRepository repository;

	private final UsersService usersService;
	private final MassagesService massagesService;

	@Transactional
	public Reservations addReservations(Long userId, Long massageId, ReservationAddRequestDto dto) {
		Users user = usersService.getUser(userId);
		Massages massage = massagesService.getMassage(massageId);

		dto.setUser(user);
		dto.setMassage(massage);
		Reservations reservation = dto.toEntity();

		return repository.save(reservation);
	}

}
