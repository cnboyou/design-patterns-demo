package com.ehi.patterns;

import com.ehi.patterns.action.observer.LoginService;
import com.ehi.patterns.action.state.StateTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class DesignPatternsDemoApplication implements CommandLineRunner {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StateTest stateTest;


    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("********State********");
        stateTest.test();
        System.out.println();
        System.out.println("********Observer********");
        loginService.publishEvent();
    }
}
