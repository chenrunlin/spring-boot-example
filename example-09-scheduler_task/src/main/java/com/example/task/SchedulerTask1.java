package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author runlin.chen
 * @version 1.0 2017-12-15 10:50
 **/
@Component
public class SchedulerTask1 {

    private int count = 0;

    /**
     * @Scheduled 参数可以接受两种定时的设置，
     * 一种是我们常用的cron
     * 一种是 fixedRate = 6000，两种都表示每隔六秒打印一下内容。
     */

    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  " + (count ++));
    }

}
