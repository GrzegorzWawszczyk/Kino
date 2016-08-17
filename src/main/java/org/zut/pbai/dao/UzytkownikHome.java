package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.Uzytkownik;

/**
 * Home object for domain model class Uzytkownik.
 * @see .Uzytkownik
 * @author Hibernate Tools
 */
@Stateless
public class UzytkownikHome {

	private static final Log log = LogFactory.getLog(UzytkownikHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Uzytkownik transientInstance) {
		log.debug("persisting Uzytkownik instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Uzytkownik persistentInstance) {
		log.debug("removing Uzytkownik instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Uzytkownik merge(Uzytkownik detachedInstance) {
		log.debug("merging Uzytkownik instance");
		try {
			Uzytkownik result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Uzytkownik findById(Integer id) {
		log.debug("getting Uzytkownik instance with id: " + id);
		try {
			Uzytkownik instance = entityManager.find(Uzytkownik.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
