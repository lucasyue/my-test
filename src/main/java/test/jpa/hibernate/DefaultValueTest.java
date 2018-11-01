package test.jpa.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import test.jpa.hibernate.defaultvalue.MyTable;

public class DefaultValueTest extends BaseTest {
	@Test   
	public void testDefaultValue(){
    	Session session = null;
        try {
			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			t.begin();
			session.createCriteria(MyTable.class).setFirstResult(10).list();
			MyTable m1 = new MyTable();
			m1.setId("5");
			m1.setName("ccc");
			m1.setSex(true);
			session.save(m1);
			t.commit();
        } finally {
        	session.flush();
			session.close();
		}
    }
}
