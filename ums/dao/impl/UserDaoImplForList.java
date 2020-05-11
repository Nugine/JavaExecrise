package ums.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ums.dao.UserDao;
import ums.entity.User;

public class UserDaoImplForList implements UserDao {
    private final List<User> users;

    public UserDaoImplForList() {
        users = new ArrayList<User>();
    }

    public User deleteByEmail(final String email) {
        final Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            final User user = it.next();
            if (user.getEmail().equalsIgnoreCase(email)) {
                it.remove();
                return user;
            }
        }
        return null;
    }

    public void insert(final User user) {
        users.add(user);
    }

    public List<User> selectAll() {
        return users;
    }

    public User selectByEmail(final String email) {
        for (final User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean update(final User userData) {
        final User user = selectByEmail(userData.getEmail());
        if (user != null) {
            users.remove(user);
            users.add(user);
        }
        return user != null;
    }
}
