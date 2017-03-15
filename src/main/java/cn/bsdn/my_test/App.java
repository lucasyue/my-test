package cn.bsdn.my_test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Hello world!
 *
 */
public class App 
{	
	private Environment env;
	private ClassPathXmlApplicationContext context;
	@Before
	public void tearUp(){
		String location="classpath:context.xml";
		context=new ClassPathXmlApplicationContext(location);
		context.refresh();
	}
    @Test
    public void t1(){
    	env=context.getEnvironment();
    	BasicDataSource dataSource=(BasicDataSource) context.getBean("dataSource");
    	try {
    		Connection con1=dataSource.getConnection();
			print(dataSource);
			con1.close();
    		Connection con2=dataSource.getConnection();
			print(dataSource);
    		Connection con3=dataSource.getConnection();
			print(dataSource);
			con3.close();
    		Connection con4=dataSource.getConnection();
			print(dataSource);
			con4.close();
    		Connection con5=dataSource.getConnection();
			print(dataSource);
    		Connection con6=dataSource.getConnection();
			print(dataSource);
    		Thread.sleep(10);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    public static void printInit(BasicDataSource dataSource) {
    	BasicDataSource ds = dataSource;
		int maxactive=dataSource.getMaxActive();
		int minidle=dataSource.getMinIdle();
		boolean remAba=dataSource.getRemoveAbandoned();
		System.out.println(ds.getInitialSize());
		System.out.println(ds.getDefaultAutoCommit());
		System.out.println(maxactive);
		System.out.println(minidle);
		System.out.println(remAba);
    }
    public static void print(BasicDataSource dataSource) {
    	BasicDataSource ds = dataSource;
    	System.out.println("act "+ds.getNumActive()+" idle "+ds.getNumIdle());
    }
}
