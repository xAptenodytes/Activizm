package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Areaofresponsibility;

/**
 * Home object for domain model class Areaofresponsibility.
 * @see ru.xaptenodytes.activizm.dao.Areaofresponsibility
 * @author Hibernate Tools
 */
@Stateless
public class AreaofresponsibilityHome {

	private static final Log log = LogFactory
			.getLog(AreaofresponsibilityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Areaofresponsibility transientInstance) {
		log.debug("persisting Areaofresponsibility instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Areaofresponsibility persistentInstance) {
		log.debug("removing Areaofresponsibility instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Areaofresponsibility merge(Areaofresponsibility detachedInstance) {
		log.debug("merging Areaofresponsibility instance");
		try {
			Areaofresponsibility result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Areaofresponsibility findById(Integer id) {
		log.debug("getting Areaofresponsibility instance with id: " + id);
		try {
			Areaofresponsibility instance = entityManager.find(
					Areaofresponsibility.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
