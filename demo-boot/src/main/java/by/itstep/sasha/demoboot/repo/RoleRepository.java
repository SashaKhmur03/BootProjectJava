package by.itstep.sasha.demoboot.repo;

import by.itstep.sasha.demoboot.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
