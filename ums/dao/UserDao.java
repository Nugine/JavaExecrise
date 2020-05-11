package ums.dao;

import java.util.List;

import ums.entity.User;

public interface UserDao {
	public void insert(User user);

	public User deleteByEmail(String name);

	public boolean update(User user);

	public User selectByEmail(String email);

	public List<User> selectAll();
}
