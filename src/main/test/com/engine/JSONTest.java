package com.engine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hm.engine.dao.examniation.domain.UserPhotoExams;

/**
 * Created by ant_shake_tree on 15/8/26.
 */
public class JSONTest {
    public  static void main(String[] args){
        UserPhotoExams userPhotoExams =new UserPhotoExams();
        userPhotoExams.setDoctorGuid("xxxx");
        System.out.println(JSON.toJSONString(userPhotoExams));
//        System.out.println(JSON.toJSON(userPhotoExams));
    }
}
