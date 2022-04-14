package org.example.massage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class Reservations extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Users user;

	@ManyToOne
	private Massages massage;

	@Column(columnDefinition = "char(1)", nullable = false)
	private String status;

	private LocalDate rsvDate;

	private LocalTime startTime;

	private LocalTime endTime;

	private Integer totalTime;

	@Column(columnDefinition = "text")
	private String description;

	@Builder
	public Reservations(Users user, Massages massage, String status, LocalDate date,
	                    LocalTime startTime, LocalTime endTime, Integer totalTime, String description) {
		this.user = user;
		this.massage = massage;
		this.status = status;
		this.rsvDate = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalTime = totalTime;
		this.description = description;
	}
}
