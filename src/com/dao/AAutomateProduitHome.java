package com.dao;
// Generated 7 f�vr. 2017 11:34:39 by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.models.AAutomateProduit;
import com.models.AAutomateProduitId;

/**
 * Home object for domain model class AAutomateProduit.
 * @see com.models.AAutomateProduit
 * @author Hibernate Tools
 */
public class AAutomateProduitHome {

	private static final Log log = LogFactory.getLog(AAutomateProduitHome.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}

	public void persist(AAutomateProduit transientInstance) {
		log.debug("persisting AAutomateProduit instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AAutomateProduit instance) {
		log.debug("attaching dirty AAutomateProduit instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AAutomateProduit instance) {
		log.debug("attaching clean AAutomateProduit instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AAutomateProduit persistentInstance) {
		log.debug("deleting AAutomateProduit instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AAutomateProduit merge(AAutomateProduit detachedInstance) {
		log.debug("merging AAutomateProduit instance");
		try {
			AAutomateProduit result = (AAutomateProduit) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AAutomateProduit findById(AAutomateProduitId id) {
		log.debug("getting AAutomateProduit instance with id: " + id);
		try {
			AAutomateProduit instance = (AAutomateProduit) sessionFactory.openSession()
					.get("com.models.AAutomateProduit", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AAutomateProduit> findByExample(AAutomateProduit instance) {
		log.debug("finding AAutomateProduit instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<AAutomateProduit> results = (List<AAutomateProduit>)sessionFactory.openSession().createCriteria("com.models.AAutomateProduit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
