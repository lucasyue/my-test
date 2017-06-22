package test.jpa.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.junit.Test;

import test.jpa.hibernate.model.Account;

public class ProjectionTest extends BaseTest{
    @Test   
	public void testProjection(){
    	Session session = null;
        try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Account.class);
			ProjectionList proList = Projections.projectionList().add(Property.forName("accountName").as("acName"));
			proList.add(Property.forName("accountNumber").as("acN"));
			c.setProjection(proList);
			List list = c.list();
			list.size();
        } finally {
			session.close();
		}
    }

}
