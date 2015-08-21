package com.ykh.web.conference;

import com.ykh.conference.service.impl.ConferenceServiceImpl;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.dao.user.domain.User;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserConferenceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
public class ConferenceController {
	@Autowired ConferenceServiceImpl userServcie;

    @RequestMapping(value = "/conference/{id}/{status}", method = RequestMethod.GET)
    public @ResponseBody
    Conference loginSession(@PathVariable int id,
            @PathVariable boolean status) {

        return new Conference();
    }

    @RequestMapping(value = "/conference/createconference/{applicationID}/{tempConferenceID}",
    		method = RequestMethod.POST)
    public @ResponseBody
    Conference createConference(@PathVariable int applicationID,
    		@PathVariable int tempConferenceID,
    		@RequestBody Conference confenceInfo) {
    	try {
			userServcie.createConference(applicationID, tempConferenceID,confenceInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Boolean ret =createConference(applicationID,tempConferenceID,confenceInfo);
        return confenceInfo;
    }


	public Boolean stopConference(String applicationID, Integer tempConferenceID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean deleteConference(String applicationID, Integer conferenceID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer queryUserNum(String applicationID, Integer tempConfID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean startConference(String applicationID,
			Integer tempConferenceID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public UserChannel joinConference(String applicationID,
			Integer tempConferenceID, User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer getBMSConferenceInfo(String applicationID, Integer tempConfID)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public UserConferenceStatus getUserConferenceStatus(String applicationID,
			Integer tempConfID, Integer tempUserID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Integer createConference(String applicationID, String billingCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
