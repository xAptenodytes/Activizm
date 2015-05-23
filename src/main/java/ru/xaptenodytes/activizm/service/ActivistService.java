package ru.xaptenodytes.activizm.service;

import java.util.List;

import ru.xaptenodytes.activizm.model.Activist;

public interface ActivistService {
	public void addActivist(Activist activist);
	
	public List<Activist> listActivist();
	
	public void acceptActivistApplication(Activist activist, Integer coordinatodId);

	public void suspendActivist(Integer activistId);
}
