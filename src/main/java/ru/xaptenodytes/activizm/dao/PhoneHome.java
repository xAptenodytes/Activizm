package ru.xaptenodytes.activizm.dao;

// Generated 01.06.2015 16:54:54 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.xaptenodytes.activizm.model.Phone;

/**
 * Home object for domain model class Phone.
 * @see ru.xaptenodytes.activizm.dao.Phone
 * @author Hibernate Tools
 */
@Stateless
public class PhoneHome {

	private static final Log log = LogFactory.getLog(PhoneHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Phone transientInstance) {
		log.debug("persisting Phone instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Phone persistentInstance) {
		log.debug("removing Phone instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Phone merge(Phone detachedInstance) {
		log.debug("merging Phone instance");
		try {
			Phone result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Phone findById(Integer id) {
		log.debug("getting Phone instance with id: " + id);
		try {
			Phone instance = entityManager.find(Phone.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
