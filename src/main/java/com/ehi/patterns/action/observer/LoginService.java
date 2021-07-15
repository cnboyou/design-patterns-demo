package com.ehi.patterns.action.observer;

import com.ehi.patterns.action.observer.event.LoginEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginService
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 11:13
 * @Description: TODO
 */
@Service
public class LoginService implements ApplicationEventPublisherAware {

    // 注入事件发布者
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 发布事件
     */
    public void publishEvent() {
        applicationEventPublisher.publishEvent(new LoginEvent(this, "wyh"));
    }
}