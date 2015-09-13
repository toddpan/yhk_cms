package com.ykh.services.user.impl;

import com.ykh.dao.user.TempUserDao;
import com.ykh.dao.user.domain.TempUser;
import com.ykh.services.TempUserService;
import com.ykh.services.conference.impl.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Transient;
import javax.transaction.Transactional;

/**
 * Created by ant_shake_tree on 15/9/13.
 */
@Component
public class TempUserServiceImpl implements TempUserService {
   @Autowired
    TempUserDao tempUserDao;
    @Override
    public void updateStatus(int id, int status) {
//    	tempUserDao.updateStauts(id,status);
        tempUserDao.excuteHql("update TempUser u set u.status = ? where u.idTempUser = ?",status,id);
    }

    @Override
    public void deleteByTempConferenceId(Integer tempConfID) {
        tempUserDao.deleteByTempConferenceId(tempConfID);
    }
}
