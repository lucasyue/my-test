package test.jpa.hibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import test.jpa.hibernate.model.Account;

public class TransformersTest extends BaseTest {
	@Test
	public void testTransformers() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			List<Account> list = (List) session.createSQLQuery("select * from oc_Account")
					.setResultTransformer(Transformers.TO_LIST).list();
			list.get(0);
			Map aMap = (Map) session
					.createSQLQuery("select * from oc_Account where id_='7996c063-1925-4bf2-9cb4-6ed64c33edeb'")
					.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
			aMap.get("id_");
			Account account = (Account) session
					.createSQLQuery(
							"select id_ as id,ACCOUNT_NAME_ as accountName from oc_Account where id_='7996c063-1925-4bf2-9cb4-6ed64c33edeb'")
					.addScalar("id").addScalar("accountName")
					.setResultTransformer(Transformers.aliasToBean(Account.class)).uniqueResult();
			account.getId();// 与jpa注解无关
		} finally {
			session.close();
		}
	}

	@Test
	public void getDividendRecords() {
		// 一个月
		/*
		 * select rr.* from (select
		 * rev.id_,rev.dividend_date_actual_,s.product_code_,s.
		 * existence_manager_ from (select r.* from oc_dividend_record r left
		 * join oc_event e on r.id_ = e.relation_id_ where
		 * r.dividend_date_actual_ between to_date('2017/11/01','yyyy/MM/dd')
		 * and to_date('2017/12/01','yyyy/MM/dd') and r.change_reason_<>'提前结束'
		 * and e.id_ is null) rev left join oc_dividend_header h on
		 * rev.header_id_ = h.id_ left join oc_dividend_sale_attributes s on
		 * h.sale_divi_attr_id_= s.id_) rr left join oc_dividend_plan p on
		 * (rr.product_code_ = p.product_code_ and rr.dividend_date_actual_ =
		 * p.dividend_date_) where p.id_ is null;
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		String startDate = sdf.format(c.getTime());
		c.add(Calendar.MONTH, 1);
		String endDate = sdf.format(c.getTime());
		String sql = "select rr.ID_ as id,rr.dividend_date_actual_ as dividendDateActual,rr.existence_manager_ existenceManager,rr.product_id_ as productId from "
				+ "(select rev.id_,rev.dividend_date_actual_,s.product_code_,s.existence_manager_,s.product_id_ from (select r.* from oc_dividend_record r left join oc_event e on r.id_ = e.relation_id_ "
				+ "where r.dividend_date_actual_ " + "between to_date('" + startDate + "','yyyyMMdd') and to_date('"
				+ endDate + "','yyyyMMdd')"
				+ " and r.change_reason_<>'提前结束' and e.id_ is null) rev left join oc_dividend_header h on rev.header_id_ = h.id_ left join oc_dividend_sale_attributes s on h.sale_divi_attr_id_= s.id_) rr "
				+ "left join oc_dividend_plan p on (rr.product_code_ = p.product_code_ and rr.dividend_date_actual_ = p.dividend_date_) "
				+ "where p.id_ is null";
		Session session = null;
		try {
			session = sessionFactory.openSession();
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> rsList = session.createSQLQuery(sql).addScalar("id")
					.addScalar("dividendDateActual").addScalar("existenceManager").addScalar("productId").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			for (Map<String, Object> rs : rsList) {
				String id = UUID.randomUUID().toString();
				String relationId = (String) rs.get("id");
				String productId = (String) rs.get("productId");// 哪个产品
				String desc = "分红清算要素表维护-发起分红";
				String date = "20171108";
				String onlyRemind = "1";
				String operator = (String) rs.get("existenceManager");// 哪个存续经理
				String remindType = "reminder";
				String insertSql = "insert into oc_event(id_,relation_id_,desc_,date_,operator_,only_remind_,product_id_,remind_type_)values('"
						+ id + "','" + relationId + "','" + desc + "',to_date('" + date + "','yyyyMMdd'),'" + operator + "','" + onlyRemind
						+ "','" + productId + "','" + remindType + "')";
				session.createSQLQuery(insertSql).executeUpdate();
				System.out.println(id);
			}
		} finally {
			session.close();
		}
	}
}
