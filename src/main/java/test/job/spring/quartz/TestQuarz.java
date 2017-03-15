package test.job.spring.quartz;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuarz {
	private static ClassPathXmlApplicationContext context;
	@BeforeClass
	public static void setUp(){
		context=new ClassPathXmlApplicationContext("test/quartz/test-quartz.xml");
		context.start();
		while(true){
			//System.out.println(11);
		}
	}
	@org.junit.Test
	public void run1(){
		//test1();
	}
	public static void main(String[] args) {
		Integer i1=127,j1=129;
		Integer i2=127,j2=129;
		System.out.println(i1.equals(i2)+","+j1.equals(j2));
		System.out.println(i1==i2);
		System.out.println(j1==j2);
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if("1".equals(temp)){
				a.remove(temp);
			}
		}
		System.out.println(111);
	}
	public void testSpringQuartz() {
    }
}
