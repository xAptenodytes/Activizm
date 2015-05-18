package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Coordinators;

/**
 * Home object for domain model class Coordinators.
 * @see ru.xaptenodytes.activizm.dao.Coordinators
 * @author Hibernate Tools
 */
@Stateless
public class CoordinatorsHome {

	private static final Log log = LogFactory.getLog(CoordinatorsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Coordinators transientInstance) {
		log.debug("persisting Coordinators instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Coordinators persistentInstance) {
		log.debug("removing Coordinators instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Coordinators merge(Coordinators detachedInstance) {
		log.debug("merging Coordinators instance");
		try {
			Coordinators result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Coordinators findById(Integer id) {
		log.debug("getting Coordinators instance with id: " + id);
		try {
			Coordinators instance = entityManager.find(Coordinators.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
