package test.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("test.spring")
@PropertySource("classpath:test/spring/configure.properties")
public class MyConfig {
	@Bean
    public UserDao1 userDao1(){
    	return new UserDao1();
    }
	@Value("${core.runMode}")
	private String runMode;
	public void showRunMode(){
		System.out.println(this.runMode);
	}
}
