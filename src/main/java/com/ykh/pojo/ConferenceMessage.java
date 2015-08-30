package com.ykh.pojo;

import com.gnetis.tang.conferencemanagement.util.MessageEnum;

import java.util.Random;

public class ConferenceMessage implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String messageID;
	private Integer tempconferenceID;
	private Integer tempuserID;
	private MessageEnum msgEnum;
	private String roleIDs;
	
	public ConferenceMessage() {
	}
	
	public ConferenceMessage(Integer tempconferenceID, Integer tempuserID, MessageEnum msgEnum, String roleIDs) {
		this.tempconferenceID = tempconferenceID;
		this.tempuserID = tempuserID;
		this.msgEnum = msgEnum;
		this.messageID = this.randomMessageID();
		this.roleIDs = roleIDs;
	}
	
	public ConferenceMessage(String messageID, Integer tempconferenceID, Integer tempuserID, MessageEnum msgEnum, String roleIDs) {
		this.messageID = messageID;
		this.tempconferenceID = tempconferenceID;
		this.tempuserID = tempuserID;
		this.msgEnum = msgEnum;
		this.roleIDs = roleIDs;
	}
	
	private String randomMessageID() {
		Random random = new Random(10000);
		return random.nextLong()+"";
	}
	
	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public Integer getTempconferenceID() {
		return tempconferenceID;
	}
	public void setTempconferenceID(Integer tempconferenceID) {
		this.tempconferenceID = tempconferenceID;
	}
	public Integer getTempuserID() {
		return tempuserID;
	}
	public void setTempuserID(Integer tempuserID) {
		this.tempuserID = tempuserID;
	}
	public MessageEnum getMsgEnum() {
		return msgEnum;
	}
	public void setMsgEnum(MessageEnum msgEnum) {
		this.msgEnum = msgEnum;
	}

	public String getRoleIDs() {
		return roleIDs;
	}

	public void setRoleIDs(String roleIDs) {
		this.roleIDs = roleIDs;
	}
}
