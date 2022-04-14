package org.example.massage.service.users;

import lombok.RequiredArgsConstructor;
import org.example.massage.domain.Users;
import org.example.massage.repository.UsersRepository;
import org.example.massage.web.dto.UserModifyRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    public Users getUser(Long id) {
        return usersRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public Users modifyUser(Long id, UserModifyRequestDto dto) {
        Users user = usersRepository.findById(id).orElseThrow(NullPointerException::new);

        user.modify(dto.getPwd(), dto.getName(), dto.getTel(), dto.getDescription());

        return user;
    }
}
