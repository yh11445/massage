package org.example.massage.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.massage.domain.Users;
import org.example.massage.service.users.UsersService;
import org.example.massage.web.dto.UserAddRequestDto;
import org.example.massage.web.dto.UserModifyRequestDto;
import org.example.massage.web.dto.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UsersService usersService;

	@ApiOperation(value ="사용자 추가", notes = "회원가입 기능")
	@PostMapping("/api/v1/users")
	public ResponseEntity<Object> addUser(@RequestBody UserAddRequestDto reqDto) {
		Users user = usersService.addUser(reqDto.toEntity());
		UserResponseDto resDto = new UserResponseDto(user);

		return ResponseEntity.status(HttpStatus.OK).body(resDto);
	}

	@ApiOperation(value ="사용자 조회", notes = "회원 id값을 이용하여 회원정보를 조회합니다.")
	@GetMapping("/api/v1/users/{id}")
	public ResponseEntity<Object> getUser(@PathVariable Long id) {
		Users user = usersService.getUser(id);
		UserResponseDto resDto = new UserResponseDto(user);

		return ResponseEntity.status(HttpStatus.OK).body(resDto);
	}

	@ApiOperation(value ="사용자 수정", notes = "회원정보 수정 기능")
	@PutMapping("/api/v1/users/{id}")
	public ResponseEntity<Object> modifyUser(@PathVariable Long id, @RequestBody UserModifyRequestDto reqDto) {
		Users user = usersService.modifyUser(id, reqDto);
		UserResponseDto resDto = new UserResponseDto(user);

		return ResponseEntity.status(HttpStatus.OK).body(resDto);
	}
}
