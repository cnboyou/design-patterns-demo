package com.ehi.patterns.action.observer.listener;

import com.ehi.patterns.action.observer.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: LoginListener
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 11:12
 * @Description: TODO
 */
@Component
public class LoginListener {

    @EventListener
    public void dealEvent(LoginEvent event) {
        String username = event.getUsername();
        System.out.println("username: " + username);
    }

}