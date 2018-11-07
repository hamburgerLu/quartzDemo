package com.example.quartz.helloQuzrtz;

import org.quartz.*;

import java.util.Date;


/**
 * 获取jobDetail的方法，有三种
 * 1、在job方法中的JobExecutionContext对象，分别拿取jobDetail和trigger的jobDataMap，再通过对应的方法，获取对应的参数
 * 2、在job方法中的JobExecutionContext对象，直接获取mergedJobDataMap，再通过对应的方法，获取对应的参数，但是当jobdetail和trigger中有相同的key的时候，会有以trigger的为准
 * 3、在job中把需要的参数当成成员变量，设置好get set方法后，可以直接用get方法获取对应的值（不常用，但是对于一些必须要的参数可以进行这种设置）
 */
public class HelloJob implements Job {


    private String message;
    private float floatJobDataValue;
    private double doubleJobDataValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getFloatJobDataValue() {
        return floatJobDataValue;
    }

    public void setFloatJobDataValue(float floatJobDataValue) {
        this.floatJobDataValue = floatJobDataValue;
    }

    public double getDoubleJobDataValue() {
        return doubleJobDataValue;
    }

    public void setDoubleJobDataValue(double doubleJobDataValue) {
        this.doubleJobDataValue = doubleJobDataValue;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println(new Date());

//        //获取jobExecutionContext下的mergedJobDataMap
//        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
//        System.out.println("name is"+jobKey.getName()+",group is "+jobKey.getGroup());
//
//        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
//        System.out.println("trigger name is"+triggerKey.getName()+",trigger group is "+triggerKey.getGroup());
//
//        String JobMessage = jobExecutionContext.getJobDetail().getJobDataMap().getString("message");
//        float floatJobDataValue = jobExecutionContext.getJobDetail().getJobDataMap().getFloatValue("floatJobDataValue");
//
//        String triggerMessage = jobExecutionContext.getTrigger().getJobDataMap().getString("message");
//        double doubleTriggerDataValue = jobExecutionContext.getTrigger().getJobDataMap().getDoubleValue("doubleJobDataValue");
//
//
//        System.out.println("JobMessage is:"+JobMessage);
//        System.out.println("floatJobDataValue is:"+floatJobDataValue);
//        System.out.println("triggerMessage is:"+triggerMessage);
//        System.out.println("doubleTriggerDataValue is:"+doubleTriggerDataValue);
//
//
//
//        System.out.println("=====================================================================================================");
//        //直接获取mergedJobDataMap
//        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
//
//        //当trigger和jobdetail中有相同的key的时候，会优先显示trigger中的值
//        System.out.println("message is :"+jobDataMap.getString("message"));
//        System.out.println("floatJobDataValue is :"+jobDataMap.getFloatValue("floatJobDataValue"));
//        System.out.println("doubleJobDataValue is :"+jobDataMap.getDoubleValue("doubleJobDataValue"));


        System.out.println(getMessage());
        System.out.println(getDoubleJobDataValue());
        System.out.println(getFloatJobDataValue());


        System.out.println("hello quartz!");
    }


}
