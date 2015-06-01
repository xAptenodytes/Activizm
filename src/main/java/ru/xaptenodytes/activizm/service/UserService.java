package ru.xaptenodytes.activizm.service;

import java.util.List;

import ru.xaptenodytes.activizm.model.User;


public interface UserService {
	public User getUser(Integer id);
	public User getUser(String id);
	public User getUserLogin(String login);
	public List<User> getUsers();
	public User chkAthority();
}
