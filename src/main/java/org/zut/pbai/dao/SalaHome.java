package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.Sala;

/**
 * Home object for domain model class Sala.
 * @see .Sala
 * @author Hibernate Tools
 */
@Stateless
public class SalaHome {

	private static final Log log = LogFactory.getLog(SalaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Sala transientInstance) {
		log.debug("persisting Sala instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Sala persistentInstance) {
		log.debug("removing Sala instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Sala merge(Sala detachedInstance) {
		log.debug("merging Sala instance");
		try {
			Sala result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sala findById(Integer id) {
		log.debug("getting Sala instance with id: " + id);
		try {
			Sala instance = entityManager.find(Sala.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
