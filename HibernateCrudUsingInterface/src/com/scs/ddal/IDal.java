package com.scs.ddal;

import org.hibernate.Query;

public interface IDal {

	Query dql(String query);
	void dmlInsert(Object o);
	Object dqlFind(Class c,int crank);
	void dmlUpdate(Object o);
	void dmlDelete(Object o);
	void dqlSelect();
	void closeconn();
}
