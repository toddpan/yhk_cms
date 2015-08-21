//package com.ykh.dao.user;
//
//import com.config.TestConfig;
//import com.ykh.dao.user.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.junit.Assert.*;
//
///**
// * Created by ant_shake_tree on 15/8/21.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { TestConfig.class })
//public class UserDaoTest {
//        @Autowired UserDao userDao;
//    @Test
//    public void save(){
//        User user =new User();
//        user.setAddress("地址");
//
//
//        userDao.save(user);
//    }
//}