package com.ehi.patterns.action.state.config;

import com.ehi.patterns.action.state.constant.Events;
import com.ehi.patterns.action.state.constant.States;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.*;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * ClassName: StateMachineConfig
 *
 * @Author: WangYiHai
 * @Date: 2021/7/13 10:35
 * @Description: 状态模式：状态自动机
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.SI)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions.withExternal()
                .source(States.SI).target(States.STATE1).event(Events.EVENT1).action(action())
                .and()
                .withExternal().source(States.STATE1).target(States.STATE2).event(Events.EVENT2).action(action());
    }

    @Override
    public void configure(StateMachineModelConfigurer<States, Events> model) throws Exception {
        super.configure(model);
    }

    @Override
    public void configure(StateMachineConfigBuilder<States, Events> config) throws Exception {
        super.configure(config);
    }

    @Bean
    public Action<States, Events> action() {
        return new Action<States, Events>() {
            @Override
            public void execute(StateContext<States, Events> stateContext) {
                System.out.println("from " + stateContext.getSource().getId() + " to " + stateContext.getTarget().getId());
            }
        };
    }
}