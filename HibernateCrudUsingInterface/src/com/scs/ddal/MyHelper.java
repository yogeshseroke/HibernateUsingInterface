package com.scs.ddal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MyHelper implements IDal{
			
	Configuration cfg;
	SessionFactory sf ;
	Session session;
	public MyHelper()
	{
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
	}
	@Override
	public Query dql(String query) {
		Query q = session.createQuery(query);
		return q;
	}
	@Override
	public void dmlInsert(Object o) {
       Transaction tx = session.beginTransaction();
		
		session.save(o);
		tx.commit();
		
	}
	@Override
	public Object dqlFind(Class c, int crank) {
		Object o1 = session.get(c,crank);
	    return o1;
	}
	@Override
	public void dmlUpdate(Object o) {
		Transaction tx = session.beginTransaction();
		session.update(o);
		tx.commit();
		
	}
	@Override
	public void dmlDelete(Object o) {
		Transaction tx = session.beginTransaction();
		session.delete(o);
		tx.commit();
		
	}
	@Override
	public void dqlSelect() {
		Transaction tx = session.beginTransaction();
		//session.select(o);
		tx.commit();
		
	}
	@Override
	public void closeconn() {
		session.close();
		
	}
}
