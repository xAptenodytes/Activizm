package ru.xaptenodytes.activizm.dao;

import java.util.List;

import ru.xaptenodytes.activizm.model.Coordinator;

public interface CoordinatorDAO {
	public Coordinator getCoordinatorById(Integer id);
	
	public List<Coordinator> getCoordinatorsByCriteria(Coordinator coordinator);
	
	
}
