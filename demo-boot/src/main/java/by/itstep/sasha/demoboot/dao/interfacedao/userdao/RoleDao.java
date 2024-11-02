package by.itstep.sasha.demoboot.dao.interfacedao.userdao;

import by.itstep.sasha.demoboot.entity.user.User;

public interface UserDao {

    User findByEmail(String email);
}
