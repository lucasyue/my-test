package test.spring;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class UserDao2 {
	public void insert() {
		System.out.println(222);
	}
}