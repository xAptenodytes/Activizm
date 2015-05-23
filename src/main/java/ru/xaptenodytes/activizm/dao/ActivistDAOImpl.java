package ru.xaptenodytes.activizm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.xaptenodytes.activizm.model.Activist;

@Repository
public class ActivistDAOImpl implements ActivistDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Activist getActivistById(Integer id) {
		
		return null;
	}

	@Override
	public Activist getActivistByLogin(String login) {
		
		return null;
	}

	@Override
	public List<Activist> getActivists() {
		
		return null;
	}

	@Override
	public List<Activist> getActivistsByCriteria(Activist activist) {
		
		return null;
	}

	@Override
	public void addActivist(Activist activist) {
		
		
	}

	@Override
	public void suspendActivist(Integer activistId) {
		
		
	}

	private void updateOrSave(Activist activist) {
		
		
	}

}
