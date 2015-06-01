package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Schedulewithweekdays;

/**
 * Home object for domain model class Schedulewithweekdays.
 * @see ru.xaptenodytes.activizm.dao.Schedulewithweekdays
 * @author Hibernate Tools
 */
@Stateless
public class SchedulewithweekdaysHome {

	private static final Log log = LogFactory
			.getLog(SchedulewithweekdaysHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Schedulewithweekdays transientInstance) {
		log.debug("persisting Schedulewithweekdays instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Schedulewithweekdays persistentInstance) {
		log.debug("removing Schedulewithweekdays instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Schedulewithweekdays merge(Schedulewithweekdays detachedInstance) {
		log.debug("merging Schedulewithweekdays instance");
		try {
			Schedulewithweekdays result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Schedulewithweekdays findById(Integer id) {
		log.debug("getting Schedulewithweekdays instance with id: " + id);
		try {
			Schedulewithweekdays instance = entityManager.find(
					Schedulewithweekdays.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
