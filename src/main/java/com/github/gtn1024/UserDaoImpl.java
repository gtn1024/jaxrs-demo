package com.github.gtn1024;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Singleton
public class UserDaoImpl implements UserDao {
    private final List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public User addUser(User user) {
        if (users.stream().anyMatch(u -> u.getId().equals(user.getId()))) {
            return null;
        }
        users.add(user);
        return user;
    }

    @Override
    public boolean updateUser(Integer id, User user) {
        for (var i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public User getUser(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
