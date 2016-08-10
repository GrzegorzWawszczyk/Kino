package org.zut.pbai.dao;
// default package
// Generated 2016-08-10 20:38:02 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zut.pbai.model.Bilet;

/**
 * Home object for domain model class Bilet.
 * @see .Bilet
 * @author Hibernate Tools
 */
@Stateless
public class BiletHome {

	private static final Log log = LogFactory.getLog(BiletHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Bilet transientInstance) {
		log.debug("persisting Bilet instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Bilet persistentInstance) {
		log.debug("removing Bilet instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Bilet merge(Bilet detachedInstance) {
		log.debug("merging Bilet instance");
		try {
			Bilet result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bilet findById(int id) {
		log.debug("getting Bilet instance with id: " + id);
		try {
			Bilet instance = entityManager.find(Bilet.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
