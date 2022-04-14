package org.example.massage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Massages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "char(1)")
	private String type;

	private Integer time;

	private Integer price;

	@Builder
	public Massages(String type, Integer time, Integer price) {
		this.type = type;
		this.time = time;
		this.price = price;
	}
}
