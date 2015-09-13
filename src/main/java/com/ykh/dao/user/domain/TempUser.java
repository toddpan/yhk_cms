package com.ykh.dao.user.domain;

import com.alibaba.fastjson.JSON;
import com.ykh.pojo.UserServiceDTO;
import com.ykh.tang.agent.vo.UserChannel;

import javax.persistence.*;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@Table
@Entity
public class TempUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTempUser;

    private Integer userId;
    private  String username;
    private Integer clientType;
    private  Integer pinCode;
    private Integer tempConferenceId;
//    private domain" type="i"/>
//    <element name="status" type="u"/>
//    <element name="ip" type="au" size="4"/>
//    <element name="role_type" type="au"/>
//    <element name="time " type="t"/>
    private int status;
    @Convert(converter = UserChannelConverJson.class)
    private UserServiceDTO userChannel;



    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdTempUser() {
        return idTempUser;
    }

    public void setIdTempUser(Integer idTempUser) {
        this.idTempUser = idTempUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public Integer getTempConferenceId() {
        return tempConferenceId;
    }

    public void setTempConferenceId(Integer tempConferenceId) {
        this.tempConferenceId = tempConferenceId;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
    public  static  class  UserChannelConverJson implements AttributeConverter<UserServiceDTO,String>{

        @Override
        public String convertToDatabaseColumn(UserServiceDTO attribute) {
            return JSON.toJSONString(attribute);
        }

        @Override
        public UserServiceDTO convertToEntityAttribute(String dbData) {
            return JSON.parseObject(dbData,UserServiceDTO.class);
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserServiceDTO getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(UserServiceDTO userChannel) {
        this.userChannel = userChannel;
    }
}
