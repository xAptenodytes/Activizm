package ru.xaptenodytes.activizm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.xaptenodytes.activizm.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public User getUserById(Integer id) {
		
		return null;
	}

	@Override
	public User getUserByLogin(String login) {
		
		return null;
	}

	@Override
	public List<User> getUsers() {
		
		return null;
	}

	@Override
	public List<User> getUsersByCriteria(User user) {
		
		return null;
	}

	@Override
	public void addUser(User user) {
		
		
	}

	@Override
	public void suspendUser(Integer userId) {
		
		
	}

	private void updateOrSave(User user) {
		
		
	}

}
