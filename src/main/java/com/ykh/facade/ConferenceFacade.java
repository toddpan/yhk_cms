package com.ykh.facade;

import com.ykh.dao.conference.domain.Conference;
import com.ykh.vo.body.ConferenceSeedBody;
import com.ykh.vo.req.UserConferenceRequest;
import com.ykh.vo.res.*;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public interface ConferenceFacade {
    ConferenceResponse openConference(Conference conference);

    ConferenceResponse modifyConference(Conference conference);

    CreateConferenceResponse createConference(Conference conference);

    Response stopConference(ConferenceSeedBody conference);

    Response deleteConference(ConferenceSeedBody conference);

    UserNumResponse queryUserNum(ConferenceSeedBody conference);

    UserConferenceStatusResponse getUserConferenceStatus(ConferenceSeedBody conference);

    Response startConference(ConferenceSeedBody conference);

    UserChannelResponse joinConference(UserConferenceRequest request);

    BmsResponse getBMSConferenceInfo(ConferenceSeedBody conference);
}
