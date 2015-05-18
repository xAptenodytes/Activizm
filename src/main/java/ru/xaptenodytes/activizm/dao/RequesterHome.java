package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Requester;

/**
 * Home object for domain model class Requester.
 * @see ru.xaptenodytes.activizm.dao.Requester
 * @author Hibernate Tools
 */
@Stateless
public class RequesterHome {

	private static final Log log = LogFactory.getLog(RequesterHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Requester transientInstance) {
		log.debug("persisting Requester instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Requester persistentInstance) {
		log.debug("removing Requester instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Requester merge(Requester detachedInstance) {
		log.debug("merging Requester instance");
		try {
			Requester result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Requester findById(Integer id) {
		log.debug("getting Requester instance with id: " + id);
		try {
			Requester instance = entityManager.find(Requester.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
