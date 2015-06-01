package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Organisationeventtype;

/**
 * Home object for domain model class Organisationeventtype.
 * @see ru.xaptenodytes.activizm.dao.Organisationeventtype
 * @author Hibernate Tools
 */
@Stateless
public class OrganisationeventtypeHome {

	private static final Log log = LogFactory
			.getLog(OrganisationeventtypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Organisationeventtype transientInstance) {
		log.debug("persisting Organisationeventtype instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Organisationeventtype persistentInstance) {
		log.debug("removing Organisationeventtype instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Organisationeventtype merge(Organisationeventtype detachedInstance) {
		log.debug("merging Organisationeventtype instance");
		try {
			Organisationeventtype result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Organisationeventtype findById(Integer id) {
		log.debug("getting Organisationeventtype instance with id: " + id);
		try {
			Organisationeventtype instance = entityManager.find(
					Organisationeventtype.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
