package test.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;

@Component
@DisallowConcurrentExecution
public class JobConcurrentTest implements Job {
	@DataProvider
	public List<Map<String,Object>> testDS(){
		System.out.println(1111);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(2222);
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> rs = new HashMap<String,Object>();
		rs.put("name", "fdsadfsaf");
		list.add(rs);
		return list ;
	}
	
	@Expose
	public void test(){
		System.out.println(1111);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(2222);
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("b" + new Date());
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("e" + new Date());
	}

	public static void main(String[] args) {
		try{  
            SchedulerFactory factory = new StdSchedulerFactory();  
            Scheduler scheduler = factory.getScheduler();  
              
            JobDetail job = JobBuilder.newJob(JobConcurrentTest.class)
                    .withIdentity("MyJob", "MyGroup")  
                    .build();  
              
            CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger()  
                    .withIdentity("Trigger", "MyGroup")  
                    .startAt(new Date(System.currentTimeMillis()+5*1000))  
                    .endAt(new Date(System.currentTimeMillis()+5*1000+60*1000))  
                    .withSchedule(CronScheduleBuilder.  
                            cronSchedule("0/5 * * * * ?"))  
                    .build();  
  
            scheduler.scheduleJob(job, trigger);  
            scheduler.start();  
            
            Thread.sleep(2*60*1000);  
              
            scheduler.shutdown(true);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
	}
}
