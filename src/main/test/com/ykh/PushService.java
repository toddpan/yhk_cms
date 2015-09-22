package com.ykh;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class PushService {
	static Logger logger =Logger.getLogger(PushService.class); 
	public String push(String url,String servicename,Object request){
		HttpPost httppost = new HttpPost(
				url+servicename);
//		httppost.setHeader("Content-Type", "application/xml; charset=UTF-8");
		httppost.setHeader("Content-Type", "application/json; charset=UTF-8");
		String json= JSON.toJSONString(request);


		System.out.println(json);
		httppost.setEntity(new StringEntity(json,Charset.forName("UTF-8")));
		HttpClient client = new DefaultHttpClient();
		String re="";
		try {
			HttpResponse response = client.execute(httppost);
			re =EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			return  re;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return re;
	}
	public String pushJson(String url,String servicename,String json){
		HttpPost httppost = new HttpPost(
				url+servicename);
//		httppost.setHeader("Content-Type", "application/xml; charset=UTF-8");
		httppost.setHeader("Content-Type", "application/json; charset=UTF-8");


		httppost.setEntity(new StringEntity(json,Charset.forName("UTF-8")));
		HttpClient client = new DefaultHttpClient();
		String re="";
		try {
			HttpResponse response = client.execute(httppost);
			re =EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			return  re;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return re;
	}
}
