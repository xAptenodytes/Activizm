package ru.xaptenodytes.activizm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.xaptenodytes.activizm.dao.ActivistDAO;
import ru.xaptenodytes.activizm.model.Activist;

@Service
public class ActivistServiceImpl implements ActivistService {
	
	@Autowired
	private ActivistDAO activistDAO;
	 
	@Transactional
	public void addActivist(Activist activist) {
		activistDAO.addActivist(activist);
	}

	@Transactional
	public List<Activist> listActivist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void acceptActivistApplication(Activist activist,
			Integer coordinatodId) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void suspendActivist(Integer activistId) {
		// TODO Auto-generated method stub
		
	}	 
}
