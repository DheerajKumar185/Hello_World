package com.tech.doks.quartz.simple;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {
		
		//Define a job and tie it to our job class
		
		JobDetail job = JobBuilder.newJob(QuartzJob.class).build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
	}

}
