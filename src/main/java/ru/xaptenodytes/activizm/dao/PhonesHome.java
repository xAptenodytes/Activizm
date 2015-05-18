package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Phones;

/**
 * Home object for domain model class Phones.
 * @see ru.xaptenodytes.activizm.dao.Phones
 * @author Hibernate Tools
 */
@Stateless
public class PhonesHome {

	private static final Log log = LogFactory.getLog(PhonesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phones transientInstance) {
		log.debug("persisting Phones instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Phones persistentInstance) {
		log.debug("removing Phones instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phones merge(Phones detachedInstance) {
		log.debug("merging Phones instance");
		try {
			Phones result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phones findById(Integer id) {
		log.debug("getting Phones instance with id: " + id);
		try {
			Phones instance = entityManager.find(Phones.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
