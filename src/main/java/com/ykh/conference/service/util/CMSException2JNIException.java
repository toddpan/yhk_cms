package com.ykh.conference.service.util;

import com.ykh.conference.service.exception.JNIException;
import com.ykh.tang.agent.excep.CMSException;


public class CMSException2JNIException {

	public static JNIException getJNIException(CMSException cmsExcep)
	{
		if(cmsExcep == null)
			return null;

		JNIException jniExcep = new JNIException();
		jniExcep.setCodeID(cmsExcep.getCodeID());
		jniExcep.setMsg(cmsExcep.getMsg());
		jniExcep.setMessage(cmsExcep.getMessage());
		return jniExcep;
	}
}
