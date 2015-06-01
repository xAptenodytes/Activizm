package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Schedulewithdate;

/**
 * Home object for domain model class Schedulewithdate.
 * @see ru.xaptenodytes.activizm.dao.Schedulewithdate
 * @author Hibernate Tools
 */
@Stateless
public class SchedulewithdateHome {

	private static final Log log = LogFactory
			.getLog(SchedulewithdateHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Schedulewithdate transientInstance) {
		log.debug("persisting Schedulewithdate instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Schedulewithdate persistentInstance) {
		log.debug("removing Schedulewithdate instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Schedulewithdate merge(Schedulewithdate detachedInstance) {
		log.debug("merging Schedulewithdate instance");
		try {
			Schedulewithdate result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Schedulewithdate findById(Integer id) {
		log.debug("getting Schedulewithdate instance with id: " + id);
		try {
			Schedulewithdate instance = entityManager.find(
					Schedulewithdate.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
