package com.ehi.patterns.action.state;

import com.ehi.patterns.action.state.constant.Events;
import com.ehi.patterns.action.state.constant.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * ClassName: StateTest
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 11:18
 * @Description: TODO
 */
@Component
public class StateTest  {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    public void test() throws Exception {
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
    }

}