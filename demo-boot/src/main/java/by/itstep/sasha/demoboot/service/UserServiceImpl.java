package by.itstep.sasha.demoboot.service;

import by.itstep.sasha.demoboot.dto.UserDto;
import by.itstep.sasha.demoboot.entity.user.Role;
import by.itstep.sasha.demoboot.entity.user.User;
import by.itstep.sasha.demoboot.repo.RoleRepository;
import by.itstep.sasha.demoboot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getEmail(), userDto.getPhoneNumber());
        Role role = roleRepository.findByName("DEFAULT_USER");
        if (role == null) {
            role = setDefaultRole();
        }

        user.setRole(role);
        return userRepository.save(user);
    }

    private Role setDefaultRole() {
        Role role = new Role();
        role.setName("DEFAULT_USER");
        return roleRepository.save(role);
    }


    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        return new UserDto(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    }


    @Override
    @Transactional
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}