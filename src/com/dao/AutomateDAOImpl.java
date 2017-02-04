package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.models.Automate;

public class AutomateDAOImpl implements AutomateDAO 
{
	private static final String HQL_SELECT_ALL = "FROM Automate";
	private static final String HQL_DELETE_BY_NUM = "DELETE FROM Automate WHERE num_serie = :num";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
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
	
	public void persistAutomate(Automate automate)
	{
		Session session = this.sessionFactory.openSession();
		session.merge(automate);
		session.flush();
		session.close();		
	}

	public void updateAutomate(Automate automate){
		this.persistAutomate(automate);
	}	

	public Automate getAutomateByNum(Integer num)
	{
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		Automate automate = null;

		try
		{
			transaction = session.beginTransaction();
			automate = (Automate) session.get(Automate.class, num);
			if(automate == null)
				return null;
		}
		catch(HibernateException he)
		{
			if(he != null) transaction.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return automate;
	}
	public void deleteAutomateByNum(Integer num)
	{
		Session session = this.sessionFactory.openSession();
		Transaction transaction = null;
		Query requestDeleteByNum = session.createQuery(HQL_DELETE_BY_NUM);
		requestDeleteByNum.setParameter("num", num);
		try
		{
			transaction = session.beginTransaction();
			requestDeleteByNum.executeUpdate();
			transaction.commit();
		}
		catch(HibernateException he)
		{
			if(he != null) transaction.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}
