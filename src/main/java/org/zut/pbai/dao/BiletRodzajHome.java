package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.BiletRodzaj;

/**
 * Home object for domain model class BiletRodzaj.
 * @see .BiletRodzaj
 * @author Hibernate Tools
 */
@Stateless
public class BiletRodzajHome {

	private static final Log log = LogFactory.getLog(BiletRodzajHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(BiletRodzaj transientInstance) {
		log.debug("persisting BiletRodzaj instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BiletRodzaj persistentInstance) {
		log.debug("removing BiletRodzaj instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BiletRodzaj merge(BiletRodzaj detachedInstance) {
		log.debug("merging BiletRodzaj instance");
		try {
			BiletRodzaj result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BiletRodzaj findById(int id) {
		log.debug("getting BiletRodzaj instance with id: " + id);
		try {
			BiletRodzaj instance = entityManager.find(BiletRodzaj.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
