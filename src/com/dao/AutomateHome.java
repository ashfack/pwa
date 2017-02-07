package com.dao;
// Generated 7 f�vr. 2017 07:06:28 by Hibernate Tools 5.2.0.Beta1

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

import com.models.Automate;

/**
 * Home object for domain model class Automate.
 * @see com.models.hibernate.Automate
 * @author Hibernate Tools
 */
public class AutomateHome implements AutomateDAO{

	private static final Log log = LogFactory.getLog(AutomateHome.class);
	private static final String HQL_SELECT_ALL = "FROM Automate";
	//private SessionFactory sessionFactory = getSessionFactory();
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}

	public void persistAutomate(Automate transientInstance) {
		log.debug("persisting Automate instance");
		try {
			Session session = this.sessionFactory.openSession();
			session.merge(transientInstance);
			session.flush();
			session.close();	
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Automate instance) {
		log.debug("attaching dirty Automate instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Automate instance) {
		log.debug("attaching clean Automate instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Automate persistentInstance) {
		log.debug("deleting Automate instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Automate merge(Automate detachedInstance) {
		log.debug("merging Automate instance");
		try {
			Automate result = (Automate) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Automate getAutomateByNum(java.lang.Integer id) {
		log.debug("getting Automate instance with id: " + id);
		try {
			Automate instance = (Automate) sessionFactory.openSession().get("com.models.Automate", id);
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

	public List<Automate> findByExample(Automate instance) {
		log.debug("finding Automate instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Automate> results = (List<Automate>)sessionFactory.openSession().createCriteria("com.models.Automate")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Automate> listAutomates() {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		List<Automate> automateList = new ArrayList<Automate>();
		Query requeteLister = session.createQuery(HQL_SELECT_ALL);

		try{
			transaction = session.beginTransaction();
			automateList = requeteLister.list();
		}catch(HibernateException he){
			if (transaction != null) transaction.rollback();
			he.printStackTrace();
		}finally{
			session.close();
		}

		return automateList;
	}

	@Override
	public void updateAutomate(Automate automate) {
		this.persistAutomate(automate);
	}

	@Override
	public void deleteAutomateByNum(Integer num) {
		Automate automate = getAutomateByNum(num);
		if (automate != null)
		{
			delete(automate);
		}
		
	}

}

