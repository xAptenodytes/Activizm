package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Role;

/**
 * Home object for domain model class Role.
 * @see ru.xaptenodytes.activizm.dao.Role
 * @author Hibernate Tools
 */
@Stateless
public class RoleHome {

	private static final Log log = LogFactory.getLog(RoleHome.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Role transientInstance) {
		log.debug("persisting Role instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Role persistentInstance) {
		log.debug("removing Role instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Role result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Role findById(Integer id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = entityManager.find(Role.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
