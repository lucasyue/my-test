package test.jpa.hibernate;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.bstek.bdf2.core.model.DefaultUser;

import test.jpa.hibernate.model.Account;
import test.jpa.hibernate.model.Product;
import test.jpa.hibernate.model.SaleAgencyPayAccount;

public class BaseTest {
	protected static SessionFactory sessionFactory; 
    private static Configuration cfg;
    @BeforeClass 
    public static void beforeClass() { 
       // new SchemaExport(new Configuration().configure()).create(false, true);
    	Properties p=new Properties();
    	try {
			p.load(HibernateORMappingTest.class.getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	cfg=new Configuration().addProperties(p);
    	//cfg.addAnnotatedClass(NoticeFlow.class);
        cfg.addAnnotatedClass(DefaultUser.class);
        cfg.addAnnotatedClass(Product.class);
        cfg.addAnnotatedClass(SaleAgencyPayAccount.class);
        cfg.addAnnotatedClass(Account.class);
        //cfg.addAnnotatedClass(LogInfo.class);
        sessionFactory = cfg.buildSessionFactory();
    } 
    @AfterClass 
    public static void afterClass() { 
        sessionFactory.close(); 
    }
}
