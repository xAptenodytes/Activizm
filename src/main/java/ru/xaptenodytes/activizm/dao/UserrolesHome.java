package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Userrole;

/**
 * Home object for domain model class Userroles.
 * @see ru.xaptenodytes.activizm.dao.Userroles
 * @author Hibernate Tools
 */
@Stateless
public class UserrolesHome {

	private static final Log log = LogFactory.getLog(UserrolesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userrole transientInstance) {
		log.debug("persisting Userroles instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userrole persistentInstance) {
		log.debug("removing Userroles instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userrole merge(Userrole detachedInstance) {
		log.debug("merging Userroles instance");
		try {
			Userrole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userrole findById(Integer id) {
		log.debug("getting Userroles instance with id: " + id);
		try {
			Userrole instance = entityManager.find(Userrole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
