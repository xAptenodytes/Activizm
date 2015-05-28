package ru.xaptenodytes.activizm.dao;

import java.util.List;

import ru.xaptenodytes.activizm.model.User;

public interface UserDAO {
	public User getUserById(Integer id);
	public User getUserByLogin(String login);
	public List<User> getUsers();
	public List<User> getUsersByCriteria(User User);
	public void addUser(User User);
	public void suspendUser(Integer UserId);
	
}
