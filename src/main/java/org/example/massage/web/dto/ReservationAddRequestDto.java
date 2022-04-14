package org.example.massage.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.massage.domain.Massages;
import org.example.massage.domain.Reservations;
import org.example.massage.domain.Users;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationAddRequestDto {
	@ApiModelProperty(required = false, hidden = true)
	private Users user;
	@ApiModelProperty(required = false, hidden = true)
	private Massages massage;

	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime startTime;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime endTime;

	private Integer totalTime;

	private String description;

	@Builder
	public ReservationAddRequestDto(Users user, Massages massage, LocalDate date, LocalTime startTime,
	                                LocalTime endTime, Integer totalTime, String description) {
		this.user = user;
		this.massage = massage;
		this.status = "1";
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalTime = totalTime;
		this.description = description;
	}

	public Reservations toEntity() {
		return Reservations.builder()
				.user(user)
				.massage(massage)
				.status(status)
				.date(date)
				.startTime(startTime)
				.endTime(endTime)
				.totalTime(totalTime)
				.description(description)
				.build();
	}
}
