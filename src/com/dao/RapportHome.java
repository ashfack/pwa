package com.dao;
// Generated 7 f�vr. 2017 11:34:39 by Hibernate Tools 5.2.0.Beta1

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.models.Rapport;
import com.models.RapportId;

/**
 * Home object for domain model class Rapport.
 * @see com.models.Rapport
 * @author Hibernate Tools
 */
public class RapportHome {

	private static final String HQL_SELECT_ALL = "FROM Rapport";
	private static final Log log = LogFactory.getLog(RapportHome.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}
	
	public void persist(Rapport transientInstance) {
		log.debug("persisting Rapport instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rapport instance) {
		log.debug("attaching dirty Rapport instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Rapport instance) {
		log.debug("attaching clean Rapport instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rapport persistentInstance) {
		log.debug("deleting Rapport instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rapport merge(Rapport detachedInstance) {
		log.debug("merging Rapport instance");
		try {
			Rapport result = (Rapport) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rapport findById(RapportId id) {
		log.debug("getting Rapport instance with id: " + id);
		try {
			Rapport instance = (Rapport) sessionFactory.openSession().get("com.models.Rapport", id);
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

	public List<Rapport> findByExample(Rapport instance) {
		log.debug("finding Rapport instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Rapport> results = (List<Rapport>)sessionFactory.openSession().createCriteria("com.models.Rapport")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Rapport> listRapports() {
		log.debug("finding Rapport instance by example");
		try {
			Session session = this.sessionFactory.openSession();
			Transaction transaction = null;
			List<Rapport> rapportList = new ArrayList<Rapport>();
			Query requeteLister = session.createQuery(HQL_SELECT_ALL);

			try{
				transaction = session.beginTransaction();
				rapportList = requeteLister.list();
			}catch(HibernateException he){
				if (transaction != null) transaction.rollback();
				he.printStackTrace();
			}finally{
				session.close();
			}

			return rapportList;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void update(Rapport rapport) {
		this.persist(rapport);
	}
}
