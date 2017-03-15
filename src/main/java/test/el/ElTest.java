package test.el;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import com.bstek.bdf2.core.model.DefaultUser;

import test.Util;

public class ElTest {
	public static void testEl(){
		JexlEngine elEg=new JexlEngine();
		org.apache.commons.jexl2.Expression epr=elEg.createExpression("util.formatDate(entity.endOfRedemption,\"MM-dd\")");
		JexlContext elContext = new MapContext();
		Util util=new Util();
		elContext.set("util", util);
		util.formatDate(new Date(), "MM-dd");
		Map<String, Object> business=new HashMap<String,Object>();
    	DefaultUser sf=new DefaultUser();
		sf.setCname("announcementBasis");
		sf.setBirthday(new Date());
		BeanMap map=new BeanMap(sf);
    	business.putAll(map);
    	elContext.set("entity", business);
		String rs=epr.evaluate(elContext).toString();
		System.out.println(rs);
	}
}
