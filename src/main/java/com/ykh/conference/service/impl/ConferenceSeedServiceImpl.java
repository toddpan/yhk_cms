package com.ykh.conference.service.impl;

import com.ykh.conference.service.ConferenceSeedService;
import com.ykh.dao.conference.ConferenceSeedDao;
import com.ykh.dao.conference.domain.ConferenceSeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Component
public class ConferenceSeedServiceImpl implements ConferenceSeedService {
    @Autowired
    ConferenceSeedDao conferenceSeedDao;
    @Override
    public synchronized Integer getConfTempId(Integer confId,Integer appid, String name) {
        ConferenceSeed conferenceSeed=new ConferenceSeed(confId,appid,name);
        conferenceSeedDao.save(conferenceSeed);
        Integer seed =conferenceSeed.getConfId();
        if (conferenceSeed.getConfId() >=Integer.MAX_VALUE-1){
            conferenceSeedDao.deleteAll();
            conferenceSeed.setConfId(1);
            conferenceSeedDao.save(conferenceSeed);
            return  1;
        }

        return seed;
    }
}
