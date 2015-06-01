package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Usersubcommunity;

/**
 * Home object for domain model class Usersubcommunity.
 * @see ru.xaptenodytes.activizm.dao.Usersubcommunity
 * @author Hibernate Tools
 */
@Stateless
public class UsersubcommunityHome {

	private static final Log log = LogFactory
			.getLog(UsersubcommunityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usersubcommunity transientInstance) {
		log.debug("persisting Usersubcommunity instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usersubcommunity persistentInstance) {
		log.debug("removing Usersubcommunity instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usersubcommunity merge(Usersubcommunity detachedInstance) {
		log.debug("merging Usersubcommunity instance");
		try {
			Usersubcommunity result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usersubcommunity findById(Integer id) {
		log.debug("getting Usersubcommunity instance with id: " + id);
		try {
			Usersubcommunity instance = entityManager.find(
					Usersubcommunity.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
