//package test.uflo;
//
//import javax.annotation.Resource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import com.bstek.uflo.env.EnvironmentProvider;
//
//@Component
//public class TestEnvironmentProvider implements EnvironmentProvider {
//	@Resource
//	private SessionFactory sessionFactory;
//	
//	@Resource(name="transactionManager")
//	private PlatformTransactionManager platformTransactionManager;
//	public String getTempFileStorePath() {
//		return System.getProperty("java.io.tmpdir");
//	}
//
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//
//
//	public PlatformTransactionManager getPlatformTransactionManager() {
//		return platformTransactionManager;
//	}
//
//
//	public void setPlatformTransactionManager(
//			PlatformTransactionManager platformTransactionManager) {
//		this.platformTransactionManager = platformTransactionManager;
//	}
//
//
//	public String getLoginUser() {
//		return "anonymous";
//	}
//
//
//	public String getCategoryId() {
//		return "bstek";
//	}
//
//}