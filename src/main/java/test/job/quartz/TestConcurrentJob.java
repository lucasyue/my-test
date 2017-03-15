package test.job.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestConcurrentJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String jobName=context.getJobDetail().getKey().getName();
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(jobName+"beginc"+sdf.format(date1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date2=new Date();
		System.out.println(jobName+" endc"+sdf.format(date2));		
	}

}
