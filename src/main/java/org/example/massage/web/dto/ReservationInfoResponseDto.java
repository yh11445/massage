package org.example.massage.web.dto;

import lombok.Getter;
import org.example.massage.domain.Massages;
import org.example.massage.domain.Reservations;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class ReservationInfoResponseDto {
	private Long id;
	private String status;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Integer totalTime;
	private String description;
	private String massageType;
	private Integer price;

	public ReservationInfoResponseDto(Reservations reservation, Massages massage) {
		this.id = reservation.getId();
		this.status = reservation.getStatus();
		this.date = reservation.getRsvDate();
		this.startTime = reservation.getStartTime();
		this.endTime = reservation.getEndTime();
		this.totalTime = reservation.getTotalTime();
		this.description = reservation.getDescription();
		this.massageType = massage.getType();
		this.price = massage.getPrice();
	}
}
