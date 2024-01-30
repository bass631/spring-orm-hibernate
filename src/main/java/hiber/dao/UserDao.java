package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getListUsers();
    List<User> findUsersListByModelAndSeriesCar(String model, int series);
}
