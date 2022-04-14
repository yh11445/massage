package org.example.massage.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.massage.domain.Massages;
import org.example.massage.domain.Reservations;
import org.example.massage.service.massages.MassagesService;
import org.example.massage.service.reservations.ReservationsService;
import org.example.massage.web.dto.ReservationAddRequestDto;
import org.example.massage.web.dto.ReservationInfoResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservationController {

	private final ReservationsService reservationsService;
	private final MassagesService massagesService;

	@ApiOperation(value = "마사지 예약", notes = "마사지를 예약한다")
	@PostMapping("/api/v1/reservation")
	public ResponseEntity<Object> addReservation(Long userId, Long massageId,
	                                             @RequestBody ReservationAddRequestDto dto) {

		Reservations reservation = reservationsService.addReservations(userId, massageId, dto);
		Massages massage = massagesService.getMassage(massageId);

		ReservationInfoResponseDto infoDto = new ReservationInfoResponseDto(reservation, massage);

		return ResponseEntity.status(HttpStatus.OK).body(infoDto);
	}
}
