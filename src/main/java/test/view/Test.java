package test.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.model.DefaultUser;
import com.bstek.bdf2.core.service.IFrameworkService;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.annotation.TaskScheduler;
import com.bstek.dorado.core.el.Expression;
import com.bstek.dorado.core.el.ExpressionHandler;
import com.bstek.dorado.view.socket.Message;
import com.bstek.dorado.view.socket.Socket;
import com.bstek.dorado.view.socket.SocketReceiveListener;
import com.bstek.dorado.view.task.LongTask;
import com.bstek.dorado.view.task.TaskState;
import com.bstek.dorado.view.task.TaskStateInfo;

@Component
public class Test {
    @Resource(name="dorado.expressionHandler")
    private ExpressionHandler expressionHandler;
//	@Resource(name=UfloService.BEAN_ID)
//	private UfloService ufloService;
	@Expose
	public void messageService(Socket socket){
//		(new SocketServerThread(socket) {
//	        @Override
//	        protected void run(Socket socket)  {
//	            while (socket.isConnected()) {
//	                try {
//	                    Message message = socket.receive(); // 阻塞方法
//	                    System.out.println("... ..."+message.getData());
//	                    socket.send(new Message("chat", "呵呵aaa"));
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }
//	    }).start();
		System.out.println(2222);
		socket.addReceiveListener(new SocketReceiveListener() {
	        public void onReceive(Socket socket, Message message) {
                System.out.println("...xxx...11"+message.getData());
	            try {
					socket.send(new Message("chat", "呵呵11xx"));
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    });
	}
	@Expose
	@TaskScheduler(maxRunning = 1)
	public LongTask demoLongTask(){
		return new LongTask(){
			final int count = 10;
			@Override
			public Object call() throws Exception {
				Map<String,Object>data = new HashMap<String,Object>();
				for(int i=0;i<count;i++){
					data.put("maxValue", count);
					data.put("value", i);
					setStateInfo(new TaskStateInfo(TaskState.running,"已完成人数"+i+"/"+count,data));
					Thread.sleep(1000);
				}
				data.put("value", count);
				setStateInfo(new TaskStateInfo(TaskState.running,"已完成人数"+count+"/"+count,data));
				return null;
			}
		};
	}
	@Expose
	public String testLdap(){
		String accountId = "xhy9448";
		String password="ibbvb4Xg";
		Object rs=null;//LdapAuthenticator.authenticate(accountId, password);
		IFrameworkService fs=ContextHolder.getBean(IFrameworkService.BEAN_ID);
		DefaultUser user=new DefaultUser();
		user.setUsername(accountId);
		user.setPassword(password);
		UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(accountId, password);
		try {
			fs.authenticate(user, authentication);
			return "true";
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return "false";
	}
	@Expose
	@Transactional
	public void testTranQuery(){
//		List<Product>pList=DaoUtils.createLinq(Product.class).list();
//		for(Product p:pList){}
//		DaoUtils.createHQLLinq("update " + Participator.class.getName() + " set user=:newAssignee")
//		.add("taskId= :taskId")
//		.add("user= :oldAssignee")
//		.setParameter("newAssignee", "chenyijing")
//		.setParameter("oldAssignee", "chenyijing")
//		.setParameter("taskId", Long.parseLong("223226"))
//		.executeUpdate();
//		System.out.println(pList.size());
//		DaoUtils.createHQLLinq("update " + Product.class.getName() + " set investmentAdviser='无1' where id='de3b2cf6-1401-4424-bd18-e68d273d7848'").executeUpdate();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	@Expose
	@Transactional
	public void testTran2(){
//		Session session = DaoUtils.getCurrentSession();
//		try {
//			session.createQuery("select count(ID_) from "+Product.class.getName());
//		} finally {
//			if (!TransactionSynchronizationManager.isSynchronizationActive()) {
//				session.flush();
//				session.close();
//			}
//		}
//		//if(true){throw new RuntimeException("xxxxx");}
//		Session s2=DaoUtils.getCurrentSession();
//		Session s3=DaoUtils.getCurrentSession();
//		//DaoUtils.getSessionFactory().openSession();
	}
	@Expose
	@Transactional
	public void testTran(){
		try{
			trans1();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void trans1(){
//		Session session1 = DaoUtils.getCurrentSession();
//		Session session2=DaoUtils.getSessionFactory().openSession();
//		session2.close();
//		Session session3 = DaoUtils.getCurrentSession();
//		try {
//			session3.createQuery("select count(ID_) from "+Product.class.getName());
//		} finally {
//			if (!TransactionSynchronizationManager.isSynchronizationActive()) {
//				session3.flush();
//				session3.close();
//			}
//		}
		//getsession to update WarningInstance
		//opensession to delete WarningEmail finally close
		//getsession uniquequery EmailTemplate happened error
	}
	int i=0;
	@Expose
	public String testEnvVri(){
		int r=RandomUtils.nextInt();
		if(r>1001){
			r=500;
		}
		try {
			Thread.sleep(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.i++;
		String rs=System.getProperty("catalina.base");
		System.out.println(rs+" "+this.i);
		return rs;
	}
	@Expose
	public String testEl(){
		Map<String,Object> business=new HashMap<String,Object>();
		business.put("name", "lucas");
		business.put("salesStartDate", new Date());
		String template1="名称：${util.formatDate(entity.salesStartDate,&quot;yyyy年MM月dd日&quot;)} name：${entity.accountInformation}${entity.accountInformation},时间：${entity.getTradingTime()}";
		String template="<p style=\"line-height:28px\"><span style=\"font-size:19px;font-family:华文楷体\">date：${util.formatDate(entity.salesStartDate,&quot;yyyy年MM月dd日&quot;)}【缴款通知】尊敬的诺亚客户，您好！您认购的<span style=\"background:yellow;background:yellow\">“${entity.productName}”</span>即日起进行<span style=\"background:yellow;background:yellow\">${entity.callPeriodNumber}</span>出资缴款，缴款比例为认缴出资额的<span style=\"background:yellow;background:yellow\">${entity.callRatio}%</span><span style=\"background:yellow;background:yellow\">，</span>请您于缴款截止日<span style=\"background:yellow;background:yellow\"></span>${util.formatDate(entity.callEndOfTheDay,&quot;yyyy年MM月dd日&quot;)}<span style=\"background:yellow;background:yellow\"></span>之前将足额出资款缴付至指定银行账户，务必在汇款单附言中注明“缴付投资款”字样，谢谢！</span><strong><span style=\"font-size:19px;font-family: 仿宋\"> </span></strong></p><p style=\"line-height:28px\"><strong><span style=\"font-size:19px;font-family:仿宋\">&nbsp;</span></strong></p><p><span style=\"font-size:19px;font-family:华文楷体;background: yellow;background:yellow\">发送对象</span><span style=\"font-size:19px;font-family:华文楷体\">： <span style=\"background:yellow;background:yellow\">内部范围</span>：${entity.internalTransmissionRange}</span></p><p><span style=\"font-size:19px;font-family:华文楷体\">&nbsp;</span></p><p><span style=\"font-size:19px;font-family:华文楷体;background: yellow;background:yellow\">外部范围（短信到达内部范围后发送）</span><span style=\"font-size: 19px;font-family:华文楷体\">：${entity.externalSendingRange}</span></p><p>&nbsp;</p><p><br/></p>";
//		ScheduleForm form= new ScheduleForm();
//		form.setProductName("某某产品");
//		form.setProductCode("产品代码");
//		form.setAccountInformation("acount100");
//		form.setTradingTime("2016-11-8");
//		form.setSalesStartDate(new Date());
//		expressionHandler.getJexlContext().set("entity", form);
//		if (StringUtils.hasText(template)) {
//    		Matcher m = Pattern.compile("\\$\\{.*&quot;.*\\}").matcher(template);
//    		while(m.find()) {
//    			String s = m.group();
//    			String s1 = s.replaceAll("&quot;", "\"");
//    			template = template.replace(s, s1);
//    		}
//		}
    	Expression expression = expressionHandler.compile(template);
    	if (expression == null) {
			return template;
		}
        return expression.evaluate().toString();
	}
//	@DataProvider
//	public void paging(Page<Clearing>page){
//		//DaoUtils.createLinq(Clearing.class, null, false).paging(page);
//		List<Clearing>list=DaoUtils.createLinq(Clearing.class).select(Projections.groupProperty("productId")).select("productId","supervisor","id").aliasToBean(Clearing.class).list();
//		page.setEntities(list);
//		page.setEntityCount(list.size());
//	}
//	@DataResolver
//	public void save(Collection<Clearing>datas){
//		DaoUtils.save(datas);
//	}
	@Expose
	public void backAll(Map<String,Object>params){
		//Long currTaskId=229375L;//(Long) params.get("taskId");
		//ufloService.backPrevNode(currTaskId, null);
	}
	@Expose
	public void completeAll(Map<String,Object>params){
		Long currTaskId=229375L;//(Long) params.get("taskId");
		//ufloService.backPrevNode(currTaskId, null);
//		params=new HashMap<String,Object>();
//		Map<String,Object> variables=new HashMap<String,Object>();
//		variables.put("pass", "true");
//		params.put("variables", variables);
//		params.put("taskId", currTaskId);
//		ufloService.completePeerTask(params);
		if(params==null){
			params=new HashMap<String,Object>();
			params.put("processKey", "processTestTasks1-1");
			params.put("completeStartTask", true);
		}
		Map<String, Object> variables =new HashMap<String,Object>();
		List<String>users1=new ArrayList<String>();
		users1.add("admin");
		users1.add("chenyijing");
		variables.put("users3", users1);
		variables.put("countsigners", users1);
		params.put("variables", variables);
		//ufloService.startFlow(params);
	}

	
}