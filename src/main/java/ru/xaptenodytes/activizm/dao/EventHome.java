package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Event;

/**
 * Home object for domain model class Event.
 * @see ru.xaptenodytes.activizm.dao.Event
 * @author Hibernate Tools
 */
@Stateless
public class EventHome {

	private static final Log log = LogFactory.getLog(EventHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Event transientInstance) {
		log.debug("persisting Event instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Event persistentInstance) {
		log.debug("removing Event instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Event merge(Event detachedInstance) {
		log.debug("merging Event instance");
		try {
			Event result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Event findById(Integer id) {
		log.debug("getting Event instance with id: " + id);
		try {
			Event instance = entityManager.find(Event.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
