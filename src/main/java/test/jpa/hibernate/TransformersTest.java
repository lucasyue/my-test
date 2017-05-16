package test.jpa.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import test.jpa.hibernate.model.Account;

public class TransformersTest extends BaseTest{
    @Test   
	public void testTransformers(){
    	Session session = null;
        try {
			session = sessionFactory.openSession();
			List<Account> list = (List) session.createSQLQuery("select * from oc_Account")
					.setResultTransformer(Transformers.TO_LIST).list();
			list.get(0);
			Map aMap = (Map) session.createSQLQuery("select * from oc_Account where id_='7996c063-1925-4bf2-9cb4-6ed64c33edeb'").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
		    aMap.get("id_");
		    Account account = (Account) session.createSQLQuery("select id_ as id from oc_Account where id_='7996c063-1925-4bf2-9cb4-6ed64c33edeb'").addScalar("id").setResultTransformer(Transformers.aliasToBean(Account.class)).uniqueResult();
		    account.getId();//与jpa注解无关
        } finally {
			session.close();
		}
    }
}
