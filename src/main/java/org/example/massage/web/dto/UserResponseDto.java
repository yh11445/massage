package org.example.massage.web.dto;

import lombok.Getter;
import org.example.massage.domain.Users;

@Getter
public class UserResponseDto {
	private Long id;
	private String email;
	private String name;
	private String tel;
	private String description;

	public UserResponseDto(Users user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.tel = user.getTel();
		this.description = user.getDescription();
	}
}
