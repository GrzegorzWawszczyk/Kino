package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.Seans;

/**
 * Home object for domain model class Seans.
 * @see .Seans
 * @author Hibernate Tools
 */
@Stateless
public class SeansHome {

	private static final Log log = LogFactory.getLog(SeansHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Seans transientInstance) {
		log.debug("persisting Seans instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Seans persistentInstance) {
		log.debug("removing Seans instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Seans merge(Seans detachedInstance) {
		log.debug("merging Seans instance");
		try {
			Seans result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Seans findById(Integer id) {
		log.debug("getting Seans instance with id: " + id);
		try {
			Seans instance = entityManager.find(Seans.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
