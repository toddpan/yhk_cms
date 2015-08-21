package com.ykh.facade.impl;

import com.maxc.rest.common.RestBeanUtils;
import com.maxc.rest.common.exception.ResourceNoFoundException;
import com.maxc.rest.common.exception.RestAssert;
import com.ykh.conference.service.ConferenceSeedService;
import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.conference.domain.ConferenceSeed;
import com.ykh.facade.ConferenceFacade;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.req.UserConferenceRequest;
import com.ykh.vo.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Service
public class ConferenceFacadeImpl implements ConferenceFacade {
    @Autowired
    ConferenceDao conferenceDao;
    @Autowired
    ConferenceSeedService conferenceSeedService;
    @Autowired
    ConferenceSeedDao conferenceSeedDao;
    public ConferenceResponse openConference(Conference conference) {
            RestAssert.notNull(Conference.class,conference);
            RestAssert.notNull(conference.getBillingcode(),"billingcode");
            RestAssert.notNull(conference.getConferencename(),"conferencename");
            RestAssert.notNull(conference.getAutoStopParams(),"autoStopParams");
            RestAssert.notNull(conference.getConfScale(),"confScale");
            RestAssert.notNull(conference.getPassword(), "password");
            conferenceDao.save(conference);
            ConferenceResponse response =new ConferenceResponse();
            response.setBody(conference);
            return response;
        }

    public ConferenceResponse modifyConference(Conference conference) {
        RestAssert.notNull(Conference.class,conference);
        RestAssert.notNull(conference.getConferenceId(), "conferenceId");
        Conference dao =conferenceDao.findOne(conference.getConferenceId());
        RestBeanUtils.copyProperties(dao, conference, false);
        conferenceDao.save(conference);
        ConferenceResponse response =new ConferenceResponse();
        response.setBody(conference);
        return response;
    }

    public CreateConferenceResponse createConference(Conference conference) {
        RestAssert.notNull(Conference.class,conference);
        RestAssert.notNull(conference.getConferenceId(), "conferenceId");
        RestAssert.notNull(conference.getConferencename(), "conferencename");
        Integer seed =conferenceSeedService.getConfTempId(conference.getConferenceId(),conference.getApplicationId(), conference.getConferencename());
        CreateConferenceResponse response =new CreateConferenceResponse();
        ConferenceSeedBody s =new ConferenceSeedBody();
        s.setTempConferenceId(seed);
        response.setBody(s);
        return response;
    }

    public Response stopConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conference.getTempConferenceId());
        if(conferenceSeed==null){
            throw new ResourceNoFoundException();
        }
        //TODO 停止

        return new Response();
    }

    public Response deleteConference(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conference.getTempConferenceId());
        if(conferenceSeed==null){
            throw new ResourceNoFoundException();
        }
        //TODO 删除
        return new Response();
    }

    public UserNumResponse queryUserNum(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conference.getTempConferenceId());
        if(conferenceSeed==null){
            throw new ResourceNoFoundException();
        }

        //TODO queryNum;
        UserNumResponse response =new UserNumResponse();
        return response;
    }

    public UserConferenceStatusResponse getUserConferenceStatus(ConferenceSeedBody conference) {
        RestAssert.notNull(conference);
        RestAssert.notNull(conference.getTempConferenceId(), "tempConferenceId");
        ConferenceSeed conferenceSeed =conferenceSeedDao.findOne(conference.getTempConferenceId());
        if(conferenceSeed==null){
            throw new ResourceNoFoundException();
        }
        UserConferenceStatusResponse response=new UserConferenceStatusResponse();
        return response;
    }

    public Response startConference(ConferenceSeedBody conference) {
        return new Response();
    }

    @Override
    public UserChannelResponse joinConference(UserConferenceRequest request) {
        return new UserChannelResponse();
    }

    @Override
    public BmsResponse getBMSConferenceInfo(ConferenceSeedBody conference) {
        return new BmsResponse();
    }
}
