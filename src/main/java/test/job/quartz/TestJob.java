package test.job.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
@DisallowConcurrentExecution
public class TestJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String jobName=context.getJobDetail().getKey().getName();
		Date date1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(jobName+"begin"+sdf.format(date1));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date2=new Date();
		System.out.println(jobName+" end"+sdf.format(date2));
	}
	public static void main(String[]args) throws InterruptedException, ParseException{
		new TestJob().test();
	}
	public void test() throws InterruptedException, ParseException{
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //and start it off
			JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("job1", "group1").build();
			//Trigger the job to run now, and then repeat every 40 seconds
			Date triggerStartTime=new Date();
			//MutableTrigger cronTrigger=CronScheduleBuilder.cronSchedule().build();
			CronTriggerImpl cronTrigger=new CronTriggerImpl();
			cronTrigger.setCronExpression("*/3 * * * * ?");
			cronTrigger.setName("my#trg");
			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, cronTrigger);
            scheduler.start();
            Thread.sleep(10000);
            scheduler.shutdown();
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}
}