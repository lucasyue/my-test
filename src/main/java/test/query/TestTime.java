package test.query;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import test.DBUtil;
import test.TimeDebug;

public class TestTime {
	public static void main(String[] args) throws SQLException {
          TimeDebug td = TimeDebug.getInstance("debug");
          td.debug(" 1...");
          Connection con = DBUtil.getCon();
          td.debug(" 1...");
          String sql = "select t.ID_, t.ASSIGNEE_ from UFLO_TASK t where t.ASSIGNEE_ in('gujingjing')";
  		  ResultSet rs = con.prepareStatement(sql).executeQuery();
          td.debug(" 2...");
  		  //List<Task>taskList = DaoUtils.createLinq(Task.class).add(Restrictions.in("assignee", assignees)).list();
  	      List<Object[]>taskList = new ArrayList<Object[]>();
  	      Map<String,Set<Long>>tasksMap = new HashMap<>();
  	      while(rs.next()){
  	    	BigDecimal id = rs.getBigDecimal(1);
  	    	String assignee = rs.getString(2);
	  		Object[]obj = new Object[2];
	  		obj[0] = id;
	  		obj[1] = assignee;
	  		taskList.add(obj);
  	      }
          td.debug(" 3...");
  	      for(Object[] t:taskList){
  	    	  Set<Long>tasks = tasksMap.get(t[1]);
  	    	  if(tasks == null){
  	    		  tasks = new HashSet<Long>();
  	    	  }
  	    	  tasks.add(((BigDecimal)t[0]).longValue());
  	    	  tasksMap.put((String) t[1], tasks);
  	      }
          td.debug(" 4...");
          DBUtil.releaseCon(con);
	}
}