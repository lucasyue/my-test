package test.quartz;

import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

public class QuartzTest {
	  public void startJob(){
	    	Scheduler scheduler;
			try {
				scheduler = Scheduler.class.newInstance();
				List<? extends Trigger> triList = scheduler.getTriggersOfJob(new JobKey("job065697a4-fc20-4d3e-a02a-9275da84b82f", "gopher"));
				scheduler.triggerJob(new JobKey("job065697a4-fc20-4d3e-a02a-9275da84b82f", "gopher"));
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}

