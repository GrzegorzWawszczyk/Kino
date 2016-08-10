package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.Film;

/**
 * Home object for domain model class Film.
 * @see .Film
 * @author Hibernate Tools
 */
@Stateless
public class FilmHome {

	private static final Log log = LogFactory.getLog(FilmHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Film transientInstance) {
		log.debug("persisting Film instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Film persistentInstance) {
		log.debug("removing Film instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Film merge(Film detachedInstance) {
		log.debug("merging Film instance");
		try {
			Film result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Film findById(Integer id) {
		log.debug("getting Film instance with id: " + id);
		try {
			Film instance = entityManager.find(Film.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
