package PojoEx;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.scs.ddal.IDal;
import com.scs.ddal.MyHelper;



public class CrudExample {
	 
	static void insertRecord(int crank,String cname)
	{
		IDal obj = new MyHelper();
		
		CollageExample s = new CollageExample();
		s.setCrank(crank);
		s.setCname(cname);
		obj.dmlInsert(s);
		obj.closeconn();
		
	}
	static void deleteRecord(int crank)
	{
		IDal obj = new MyHelper();
		CollageExample s = (CollageExample)obj.dqlFind(CollageExample.class,crank);
		//CollageExample s = new CollageExample(CollageExample.class,crank);
		obj.dmlDelete(s);
		obj.closeconn();
	}
	static void updateRecord(int crank,String cname)
	{
		IDal obj = new MyHelper();
		CollageExample s = (CollageExample)obj.dqlFind(CollageExample.class,crank);
		obj.dmlUpdate(s);
		obj.closeconn();
	}
	static void selectRecord()
	{
		IDal obj = new MyHelper();
		//CollageExample s = (CollageExample)obj.dqlFind(CollageExample.class,crank);
		obj.dqlSelect();
		obj.closeconn();
	}
	
	public static void main(String[] args) {
	
		insertRecord(102,"davv");
		//updaterecord(102, "abc");
		//deleteRecord(102);
	    selectRecord();
	    
	    
		

	}

}
