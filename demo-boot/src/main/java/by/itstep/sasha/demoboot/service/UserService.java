package by.itstep.sasha.demoboot.service;

import by.itstep.sasha.demoboot.dto.UserDto;
import by.itstep.sasha.demoboot.entity.user.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);

    User save(UserDto userDto);

    List<UserDto> findAllUsers();

    void deleteByEmail(String email);
}
