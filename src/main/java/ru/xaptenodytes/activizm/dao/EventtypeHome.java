package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Eventtype;

/**
 * Home object for domain model class Eventtype.
 * @see ru.xaptenodytes.activizm.dao.Eventtype
 * @author Hibernate Tools
 */
@Stateless
public class EventtypeHome {

	private static final Log log = LogFactory.getLog(EventtypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Eventtype transientInstance) {
		log.debug("persisting Eventtype instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Eventtype persistentInstance) {
		log.debug("removing Eventtype instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Eventtype merge(Eventtype detachedInstance) {
		log.debug("merging Eventtype instance");
		try {
			Eventtype result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Eventtype findById(Integer id) {
		log.debug("getting Eventtype instance with id: " + id);
		try {
			Eventtype instance = entityManager.find(Eventtype.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
