package com.ehi.patterns.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * ClassName: ScheduleTest
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 16:33
 * @Description: TODO
 */
@Service
public class ScheduleService {
    @Autowired
    private ApplicationContext applicationContext;

    private ScheduleService self;

    @Async
    public void syncTest1() {
        if (self == null) {
            System.out.println("**************self");
            self = applicationContext.getBean(ScheduleService.class);
        }
        System.out.println("test Async1");
        self.syncTest2("2222222222");
        self.syncTest3("33333333");
    }

    @Async
    public void syncTest2(String name) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test Async2" + name);
    }

    @Async
    public void syncTest3(String name) {
        System.out.println("test Async3" + name);
    }

}