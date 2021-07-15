package com.ehi.patterns.action.observer.event;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName: MyEvent
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 11:09
 * @Description: TODO
 */
public class LoginEvent extends ApplicationEvent {

    private String username;

    public LoginEvent(Object source) {
        super(source);
    }

    public LoginEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}