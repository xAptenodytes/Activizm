package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Communities;

/**
 * Home object for domain model class Communities.
 * @see ru.xaptenodytes.activizm.dao.Communities
 * @author Hibernate Tools
 */
@Stateless
public class CommunitiesHome {

	private static final Log log = LogFactory.getLog(CommunitiesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Communities transientInstance) {
		log.debug("persisting Communities instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Communities persistentInstance) {
		log.debug("removing Communities instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Communities merge(Communities detachedInstance) {
		log.debug("merging Communities instance");
		try {
			Communities result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Communities findById(Integer id) {
		log.debug("getting Communities instance with id: " + id);
		try {
			Communities instance = entityManager.find(Communities.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
