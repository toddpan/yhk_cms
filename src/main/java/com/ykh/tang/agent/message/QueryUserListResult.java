package com.ykh.tang.agent.message;

import java.util.List;

import com.ykh.tang.agent.vo.BMSUserInfo;

/**
 * 42.查询用户列表成功消息，0x000100f2
 * 
 * @author xianchao.ji
 * 
 */
public class QueryUserListResult extends BaseConfMsgResult implements IMessageHandler
{
	List<BMSUserInfo> userInfoArr; // user对象列表

	public List<BMSUserInfo> getUserInfoArr()
	{
		return userInfoArr;
	}

	public void setUserInfoArr(List<BMSUserInfo> userInfoArr)
	{
		this.userInfoArr = userInfoArr;
	}

	@Override
	public void invoke()
	{
		System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
	}
}
