package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.EventType;

/**
 * Home object for domain model class Eventtype.
 * @see ru.xaptenodytes.activizm.dao.EventType
 * @author Hibernate Tools
 */
@Stateless
public class EventtypeHome {

	private static final Log log = LogFactory.getLog(EventtypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EventType transientInstance) {
		log.debug("persisting Eventtype instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EventType persistentInstance) {
		log.debug("removing Eventtype instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EventType merge(EventType detachedInstance) {
		log.debug("merging Eventtype instance");
		try {
			EventType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EventType findById(Integer id) {
		log.debug("getting Eventtype instance with id: " + id);
		try {
			EventType instance = entityManager.find(EventType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
