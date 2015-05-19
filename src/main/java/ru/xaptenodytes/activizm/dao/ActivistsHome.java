package ru.xaptenodytes.activizm.dao;

// Generated 19.05.2015 16:37:43 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Activist;

/**
 * Home object for domain model class Activists.
 * @see ru.xaptenodytes.activizm.dao.Activist
 * @author Hibernate Tools
 */
@Stateless
public class ActivistsHome {

	private static final Log log = LogFactory.getLog(ActivistsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Activist transientInstance) {
		log.debug("persisting Activists instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Activist persistentInstance) {
		log.debug("removing Activists instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Activist merge(Activist detachedInstance) {
		log.debug("merging Activists instance");
		try {
			Activist result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Activist findById(Integer id) {
		log.debug("getting Activists instance with id: " + id);
		try {
			Activist instance = entityManager.find(Activist.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
