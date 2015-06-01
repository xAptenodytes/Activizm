package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Community;

/**
 * Home object for domain model class Community.
 * @see ru.xaptenodytes.activizm.dao.Community
 * @author Hibernate Tools
 */
@Stateless
public class CommunityHome {

	private static final Log log = LogFactory.getLog(CommunityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Community transientInstance) {
		log.debug("persisting Community instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Community persistentInstance) {
		log.debug("removing Community instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Community merge(Community detachedInstance) {
		log.debug("merging Community instance");
		try {
			Community result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Community findById(Integer id) {
		log.debug("getting Community instance with id: " + id);
		try {
			Community instance = entityManager.find(Community.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
