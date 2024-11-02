package by.itstep.sasha.demoboot.repo;

import by.itstep.sasha.demoboot.dto.UserDto;
import by.itstep.sasha.demoboot.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User save(UserDto userDto);

    @Transactional
    void deleteByEmail(String email);
}
