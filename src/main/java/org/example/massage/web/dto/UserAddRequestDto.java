package org.example.massage.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.massage.domain.Role;
import org.example.massage.domain.Users;

@Getter
@NoArgsConstructor
public class UserAddRequestDto {
	private String email;
	private String pwd;
	private String name;
	private String tel;
	private String description;

	@Builder
	public UserAddRequestDto(String email, String pwd, String name, String tel, String description) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.description = description;
	}

	public Users toEntity() {
		return Users.builder()
				.email(email)
				.pwd(pwd)
				.name(name)
				.tel(tel)
				.description(description)
				.role(Role.USER)
				.build();
	}
}
