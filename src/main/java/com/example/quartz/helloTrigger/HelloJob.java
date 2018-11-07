package com.example.quartz.helloTrigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * 获取jobDetail的方法，有三种
 * 1、在job方法中的JobExecutionContext对象，分别拿取jobDetail和trigger的jobDataMap，再通过对应的方法，获取对应的参数
 * 2、在job方法中的JobExecutionContext对象，直接获取mergedJobDataMap，再通过对应的方法，获取对应的参数，但是当jobdetail和trigger中有相同的key的时候，会有以trigger的为准
 * 3、在job中把需要的参数当成成员变量，设置好get set方法后，可以直接用get方法获取对应的值（不常用，但是对于一些必须要的参数可以进行这种设置）
 */
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println(new Date());

        System.out.println("hello quartz!");
    }


}
