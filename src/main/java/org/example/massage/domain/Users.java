package org.example.massage.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String email;

	@Column(nullable = false)
	private String pwd;

	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String name;

	@Column(columnDefinition = "varchar(15)", nullable = false)
	private String tel;

	@Column(columnDefinition = "text")
	private String description;

	@Column
	private String picture;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Builder
	public Users(String email, String pwd, String name, String tel, String description
			, String picture, Role role) {
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.description = description;
		this.picture = picture;
		this.role = role;
	}

	public Users update(String name, String picture) {
		this.name = name;
		this.picture = picture;

		return this;
	}

	public Users modify(String pwd, String name, String tel, String description) {
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.description = description;

		return this;
	}

	public String getRoleKey() {
		return this.role.getKey();
	}
}
