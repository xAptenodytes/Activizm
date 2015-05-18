package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Subcommunities;

/**
 * Home object for domain model class Subcommunities.
 * @see ru.xaptenodytes.activizm.dao.Subcommunities
 * @author Hibernate Tools
 */
@Stateless
public class SubcommunitiesHome {

	private static final Log log = LogFactory.getLog(SubcommunitiesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Subcommunities transientInstance) {
		log.debug("persisting Subcommunities instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Subcommunities persistentInstance) {
		log.debug("removing Subcommunities instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Subcommunities merge(Subcommunities detachedInstance) {
		log.debug("merging Subcommunities instance");
		try {
			Subcommunities result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Subcommunities findById(Integer id) {
		log.debug("getting Subcommunities instance with id: " + id);
		try {
			Subcommunities instance = entityManager.find(Subcommunities.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
