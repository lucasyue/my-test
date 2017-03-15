package test.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Snippet {
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MyConfig.class);
		context.scan("test.spring");
		context.refresh();
		UserDao1 userDao1 = (UserDao1) context.getBean(UserDao1.class);
		userDao1.insert();
		UserDao2 userDao2 = (UserDao2) context.getBean(UserDao2.class);
		userDao2.insert();
		MyConfig conf=context.getBean(MyConfig.class);
		conf.showRunMode();
	}
}
