package com.ehi.patterns.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * ClassName: ScheduleTest
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 16:33
 * @Description: TODO
 */
@Service
public class ScheduleTest {

    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "0/2 * * * * ? ")
    public void test() {
        System.out.println("test schedule");
        scheduleService.syncTest1();
        // scheduleService.syncTest2();
        // scheduleService.syncTest3();
    }
}