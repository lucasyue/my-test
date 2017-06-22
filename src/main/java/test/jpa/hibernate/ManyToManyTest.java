package test.jpa.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import test.jpa.hibernate.model.Product;
import test.jpa.hibernate.model.SaleAgencyPayAccount;

public class ManyToManyTest extends BaseTest {
    @Test   
	public void testManyToMany(){
    	Session session = null;
        try {
			session = sessionFactory.openSession();
			session.createCriteria(Product.class).setFirstResult(10).list();
			Product p = (Product) session.get(Product.class, "p100");
			Set<SaleAgencyPayAccount> clist = p.getSaleAgencyPayAccounts();
			//SaleAgencyPayAccount ac = p.getSaleAgencyPayAccounts().iterator().next();
			//ac.getProducts().remove(p);
			//p.getSaleAgencyPayAccounts().remove(ac);
			//session.saveOrUpdate(ac);
			//p.setSaleAgencyPayAccounts(null);
			p.setProductShortName("productShortName");
			session.saveOrUpdate(p);
			clist.size();
        } finally {
        	session.flush();
			session.close();
		}
    }
}
