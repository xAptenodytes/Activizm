package ru.xaptenodytes.activizm.dao;

// Generated 18.05.2015 14:51:45 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.ScheduleWithDate;
import ru.xaptenodytes.activizm.model.ScheduleWithDateId;

/**
 * Home object for domain model class Schedulewithdate.
 * @see ru.xaptenodytes.activizm.dao.ScheduleWithDate
 * @author Hibernate Tools
 */
@Stateless
public class SchedulewithdateHome {

	private static final Log log = LogFactory
			.getLog(SchedulewithdateHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ScheduleWithDate transientInstance) {
		log.debug("persisting Schedulewithdate instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ScheduleWithDate persistentInstance) {
		log.debug("removing Schedulewithdate instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ScheduleWithDate merge(ScheduleWithDate detachedInstance) {
		log.debug("merging Schedulewithdate instance");
		try {
			ScheduleWithDate result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ScheduleWithDate findById(ScheduleWithDateId id) {
		log.debug("getting Schedulewithdate instance with id: " + id);
		try {
			ScheduleWithDate instance = entityManager.find(
					ScheduleWithDate.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
