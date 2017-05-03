package comm.cs;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class ScheduleManager {

	public static void task() throws SchedulerException, ParseException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		long ctime = System.currentTimeMillis();
		JobDetail detail = JobBuilder.newJob(ScheduleJob.class).withIdentity("jobDetail2", "jobDetailGroup2").build();
		String cronExpression = "0 30 2 * * ?";
		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setCronExpression(cronExpression);
		trigger.setName("cronTrigger");
		trigger.setGroup("triggerGroup2");
		trigger.setJobName("jobDetail2");
		trigger.setJobGroup("jobDetailGroup2");
		scheduler.scheduleJob(detail, trigger);
		scheduler.start();
	}
	public static void main(String[] args) throws SchedulerException, ParseException {
		task();
	}
}
