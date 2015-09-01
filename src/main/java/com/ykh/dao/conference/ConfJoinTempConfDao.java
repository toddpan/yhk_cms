package com.ykh.dao.conference;

import com.ykh.dao.Dao;
import com.ykh.dao.conference.domain.ConfJoinTempConf;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
public interface ConfJoinTempConfDao extends Dao<ConfJoinTempConf,Long> {
    ConfJoinTempConf findByBmsStatusGreaterThanAndTempConfIdAndConfId(int bmsStatus, Integer tempConfId, Integer confId);

    ConfJoinTempConf findByBmsStatusLessThanAndTempConfIdAndConfId(int i, Integer seed, Integer conferenceId);

    ConfJoinTempConf findByTempConfId(Integer tempConferenceID);
    Long deleteByTempConfId(Integer tempConferenceID);

    ConfJoinTempConf findByTempConfIdAndBmsStatus(Integer tempConfID, Integer integer);
}
