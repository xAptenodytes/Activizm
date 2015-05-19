package ru.xaptenodytes.activizm.dao;

import java.util.List;

import ru.xaptenodytes.activizm.model.Activist;

public interface ActivistDAO {
	public Activist getActivistById(Integer id);
	public Activist getActivistByLogin(String login);
	public List<Activist> getActivists();
	public List<Activist> getActivistsByCriteria(Activist activist);		
}
