package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Subcommunity;

/**
 * Home object for domain model class Subcommunity.
 * @see ru.xaptenodytes.activizm.dao.Subcommunity
 * @author Hibernate Tools
 */
@Stateless
public class SubcommunityHome {

	private static final Log log = LogFactory.getLog(SubcommunityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Subcommunity transientInstance) {
		log.debug("persisting Subcommunity instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Subcommunity persistentInstance) {
		log.debug("removing Subcommunity instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Subcommunity merge(Subcommunity detachedInstance) {
		log.debug("merging Subcommunity instance");
		try {
			Subcommunity result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Subcommunity findById(Integer id) {
		log.debug("getting Subcommunity instance with id: " + id);
		try {
			Subcommunity instance = entityManager.find(Subcommunity.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
