package com.ykh.tang.agent;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@Component
public class InitAgent {
    ICMSAgent icmsAgent=ICMSAgent.getInstance();

    @PreDestroy
    public void destroy(){
        icmsAgent.agentDestroy();
    }
}
