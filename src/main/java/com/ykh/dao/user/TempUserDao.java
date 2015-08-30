package com.ykh.dao.user;

import com.ykh.dao.Dao;
import com.ykh.dao.user.domain.TempUser;

/**
 * Created by ant_shake_tree on 15/8/27.
 */
public interface TempUserDao extends Dao<TempUser,Integer> {
    TempUser findByUserId(Integer userId);

    TempUser findByUsername(String username);
}
