package com.example.quartz.helloTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

@SuppressWarnings("all")
public class HelloScheduler {


    public static void main(String[] args) throws SchedulerException {

        //创建一个jobdetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob","myJobGroup")
                .usingJobData("message","hello my jobDetail")
                .usingJobData("floatJobDataValue",3.15f).build();

        //创建一个trigger
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+3000);

        Date endDate = new Date();
        endDate.setTime(endDate.getTime()+3000);


        Trigger trigger =
                TriggerBuilder
                    .newTrigger()
                        .withIdentity("myTrigger","myTriggerGroup")
                        .startAt(startDate)
                        .endAt(endDate)
                        .withSchedule(SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(2)
                                .repeatForever())
                        .usingJobData("message","hello my trigger")
                        .usingJobData("doubleJobDataValue",3.14D)
                        .build();

        //创建一个Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        System.out.println(new Date());

        scheduler.scheduleJob(jobDetail,trigger);
    }


}
