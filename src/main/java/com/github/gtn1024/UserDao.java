package com.github.gtn1024;

import java.util.List;

public interface UserDao {
    User addUser(User user);
    boolean updateUser(Integer id, User user);
    boolean deleteUser(Integer id);
    User getUser(Integer id);
    List<User> getUsers();
}
