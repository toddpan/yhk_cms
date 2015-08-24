package com.ykh.web.conference;

import com.ykh.conference.service.impl.ConferenceServiceImpl;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;
import com.ykh.facade.ConferenceFacade;
import com.ykh.facade.impl.ConferenceFacadeImpl;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.req.UserConferenceRequest;
import com.ykh.vo.res.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conference")
//@Controller
public class ConferenceController {
	@Autowired ConferenceServiceImpl userServcie;
	@Autowired
    ConferenceFacade conferenceFacade;
    @RequestMapping(value = "/conference/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody
    Conference loginSession(@PathVariable int id,
            @PathVariable boolean status) {

        return new Conference();
    }

//    @RequestMapping(value = "/conference/createconference/{applicationID}/{tempConferenceID}",
//    		method = RequestMethod.POST)
//    public @ResponseBody
//    Conference createConference(@PathVariable int applicationID,
//    		@PathVariable int tempConferenceID,
//    		@RequestBody Conference confenceInfo) {
//    	try {
//			userServcie.createConference(applicationID, tempConferenceID,confenceInfo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	//Boolean ret =createConference(applicationID,tempConferenceID,confenceInfo);
//        return confenceInfo;
//    }


//	public Boolean stopConference(String applicationID, Integer tempConferenceID)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}




	public Integer queryUserNum(String applicationID, Integer tempConfID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/openConference", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
	public @ResponseBody ConferenceResponse OpenConference(@RequestBody Conference conference){
		return conferenceFacade.openConference(conference);
	}
    @RequestMapping(value = "/modifyConference ", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public @ResponseBody ConferenceResponse modifyConference(@RequestBody Conference conference){
        return conferenceFacade.modifyConference(conference);
    }
    @RequestMapping(value = "/createConference ", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public @ResponseBody CreateConferenceResponse createConference(@RequestBody Conference conference){
        return conferenceFacade.createConference(conference);
    }
    @RequestMapping(value = "/stopConference  ", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public @ResponseBody Response stopConference(@RequestBody ConferenceSeedBody conference){
        return conferenceFacade.stopConference(conference);
    }
    @RequestMapping(value = "/deleteConference  ", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public Response deleteConference(@RequestBody ConferenceSeedBody conference){

        return conferenceFacade.deleteConference(conference);
    }
    @RequestMapping(value = "/queryUserNum", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public UserNumResponse queryUserNum(@RequestBody ConferenceSeedBody conference){
           return conferenceFacade.queryUserNum(conference);
    }
    @RequestMapping(value = "/getUserConferenceStatus", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public UserConferenceStatusResponse getUserConferenceStatus(@RequestBody ConferenceSeedBody conference) throws Exception {
        return conferenceFacade.getUserConferenceStatus(conference);
    }
    @RequestMapping(value = "/startConference", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public Response startConference(@RequestBody ConferenceSeedBody conference) throws Exception {
        // TODO Auto-generated method stub
        return conferenceFacade.startConference(conference);
    }

    @RequestMapping(value = "/joinConference", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public UserChannelResponse joinConference(@RequestBody UserConferenceRequest request) throws Exception {
        return conferenceFacade.joinConference(request);
    }

    @RequestMapping(value = "/getBMSConferenceInfo", method = RequestMethod.POST, consumes = { ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML }, produces = {ControllerConstans.CONTENT_TYPE,ControllerConstans.CONTENT_TYPE_XML })
    public BmsResponse getBMSConferenceInfo(@RequestBody ConferenceSeedBody conference)
            throws Exception {
        // TODO Auto-generated method stub
        return conferenceFacade.getBMSConferenceInfo(conference);
    }
}
