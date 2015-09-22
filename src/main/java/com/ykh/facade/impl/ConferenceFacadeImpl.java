package com.ykh.facade.impl;

import com.maxc.rest.common.RestBeanUtils;
import com.maxc.rest.common.Utils;
import com.maxc.rest.common.exception.ResourceNoFoundException;
import com.maxc.rest.common.exception.RestAssert;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.conference.domain.ConferenceSeed;
import com.ykh.facade.ConferenceFacade;
import com.ykh.pojo.User;
import com.ykh.pojo.UserServiceDTO;
import com.ykh.services.conference.ConferenceService;
import com.ykh.services.user.UserConferenceService;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserServiceAddr;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ConferenceService;
//import com.ykh.tang.agent.ICMSAgent;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Service
public class ConferenceFacadeImpl implements ConferenceFacade {

    @Autowired
    ConferenceService conferenceService;


    public ConferenceResponse openConference(Conference conference) {
        RestAssert.notNull(Conference.class,conference);
        RestAssert.notNull(conference.getBillingcode(),"billingcode");
        RestAssert.notNull(conference.getConferencename(),"conferencename");
        RestAssert.notNull(conference.getAutoStopParams(),"autoStopParams");
        RestAssert.notNull(conference.getConfScale(),"confScale");
        conferenceService.openConference(conference);
        ConferenceResponse response =new ConferenceResponse();
        response.setBody(conference);
        return response;
    }

    public ConferenceResponse modifyConference(Conference conference) {
        RestAssert.notNull(Conference.class, conference);
        RestAssert.notNull(conference.getConferenceId(), "tempConferenceId");
        ConferenceResponse response =new ConferenceResponse();
        response.setBody(conferenceService.modifyConference(conference));
        return response;
    }

    public CreateConferenceResponse createConference(Conference conference) {
        RestAssert.notNull(Conference.class,conference);
        RestAssert.notNull(conference.getConferenceId(), "tempConferenceId");
        RestAssert.notNull(conference.getConferencename(), "conferencename");
        CreateConferenceResponse response =new CreateConferenceResponse();
        CreateConferenceResponse.CreateConferenceBody body=new CreateConferenceResponse.CreateConferenceBody();
        body.setTempConferenceId(conferenceService.createConference(conference).getConfID());
        response.setBody(body);
        return response;
    }

    public Response stopConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");

        //TODO 停止
        conferenceService.stopConference("", conference.getTempConferenceId());
        return new Response();
    }

    public Response deleteConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        //TODO 删除
        conferenceService.deleteConference("", conference.getTempConferenceId());
        return new Response();
    }

    public UserNumResponse queryUserNum(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        //TODO queryNum;
//        conferenceService.queryUserNum("",conference.getTempConferenceId());

        UserNumResponse response =new UserNumResponse();
        return response;
    }

    public UserConferenceStatusResponse getUserConferenceStatus(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
//        ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conference.getTempConferenceId());
//        if(conferenceSeed==null){
//            throw new ResourceNoFoundException();
//        }
        UserConferenceStatusResponse response=new UserConferenceStatusResponse();
        return response;
    }

    public Response startConference(ConferenceSeedBody conference) {
        RestAssert.notNull(Conference.class,conference);
        RestAssert.notNull(conference.getTempConferenceId(),"tempConferenceId");
        conferenceService.startConference(conference.getTempConferenceId());
        return new Response();
    }

    @Override
    public UserChannelResponse joinConference(User request) {
        RestAssert.notNull(User.class, request);
        RestAssert.notNull(request.getTempConferenceId(), "tempConferenceId");
//        RestAssert.notNull(request.getUserId(),"userId");
        UserServiceDTO userChannel =conferenceService.userJoinConference(request);
        UserChannelResponse response= new UserChannelResponse();

        response.setBody(userChannel);
        return response;
    }

    @Override
    public BmsResponse getBMSConferenceInfo(ConferenceSeedBody conference) {

//        conferenceService.getBMSConferenceInfo(conference.getTempConferenceId());
        return new BmsResponse();
    }

    @Override
    public PageResponse searchConferenceTemp(Conference conference) {
        RestAssert.notNull(Conference.class,conference);
        PageResponse pageResponse=new PageResponse();
        pageResponse.setBody(conferenceService.searchConference(conference));
        return pageResponse;
    }

    @Override
    public UserChannelResponse startConferecneWithUser(User request) {
        RestAssert.notNull(User.class,request);
        RestAssert.notNull(request.getConferenceId(), "conferenceId");
        UserServiceDTO res=conferenceService.startConferecneWithUser(request.getConferenceId(),request);
        UserChannelResponse response =new UserChannelResponse();
        response.setBody(res);
        return response;
    }

    public static void main(String[] args){
        System.out.println(Integer.toHexString((int) (Utils.hashCode("confScale") & 6917529027641081855L)));
    }
}
