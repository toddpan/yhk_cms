package com.ykh.tang.agent;

import com.ykh.conference.service.impl.GetmessageHandler;
import com.ykh.conference.service.impl.GetmessageHandlerByGroup;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ant_shake_tree on 15/8/30.
 */
@Component
public class JniCallBackRegister {
    private final static Logger LOGGER = Logger.getLogger(JniCallBackRegister.class);
    @Autowired
    private ICMSAgentInterface agent;
    @Autowired
    @Qualifier("getmessageHandler")
    private IMessageHandler getmessageHandler;
    @Autowired
    @Qualifier("getmessageHandlerByGroup")
    private IMessageHandler getmessageHandlerByGroup;
    @PostConstruct
    public void init() {
        LOGGER.info("[Tang CMS addMessageHandler && AddServiceMessageHandler regist ......]");
        this.regist();
        LOGGER.info("[Tang CMS addMessageHandler && AddServiceMessageHandler regist success!]");
    }

    private void regist() {
        agent.agentInit();
        agent.addMessageHandler(getmessageHandler);
        agent.addServiceMessageHandler(getmessageHandlerByGroup);
    }

    public void setAgent(ICMSAgentInterface agent) {
        this.agent = agent;
    }

    public void setGetmessageHandler(GetmessageHandler getmessageHandler) {
        this.getmessageHandler = getmessageHandler;
    }

    public void setGetmessageHandlerByGroup(
            GetmessageHandlerByGroup getmessageHandlerByGroup) {
        this.getmessageHandlerByGroup = getmessageHandlerByGroup;
    }
}

