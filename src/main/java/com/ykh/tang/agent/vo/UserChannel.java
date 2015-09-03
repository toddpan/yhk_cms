package com.ykh.tang.agent.vo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class UserChannel
{
	public  int userID;// 用户ID
	public  List<UserServiceAddr> ctsAddr= Lists.newArrayList();// 接入服务器地址列表
	public  List<UserServiceAddr> dtsAddr= Lists.newArrayList();;// 传输服务器地址列表
	public  int tempConferenceID;		  //cmsagent不使用该变量
	
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int ID)
	{
		userID = ID;
	}
	public Object getCtsAddr()
	{
		return ctsAddr;
	}
	public void setCtsAddr(List<UserServiceAddr> Addr)
	{
		ctsAddr = Addr;
	}
	public Object getDtsAddr()
	{
		return dtsAddr;
	}
	public void setDtsAddr(List<UserServiceAddr> Addr)
	{
		dtsAddr = Addr;
	}
	
	public Object getArrayInstance(){
		return new ArrayList<UserServiceAddr>();
	}
	public int getTempConferenceID()
	{
		return tempConferenceID;
	}
	public void setTempConferenceID(int tempConferenceId)
	{
		this.tempConferenceID = tempConferenceId;
	}
	
}
