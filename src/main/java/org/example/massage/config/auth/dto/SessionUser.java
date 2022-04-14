package org.example.massage.config.auth.dto;

import lombok.Getter;
import org.example.massage.domain.Users;

@Getter
public class SessionUser {
	private String name;
	private String email;
	private String picture;

	public SessionUser(Users user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}
