package com.ykh.web.user;

import com.ykh.dao.conference.ConferenceDao;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.user.service.impl.UserServiceImpl;
import com.ykh.vo.req.LoginInfo;
import com.ykh.vo.req.NullResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ant_shake_tree
 *
 */
@RestController
//@Controller
public class UserController {
	@Autowired UserServiceImpl userServcie;
	@Autowired ConferenceDao confDao;
    @RequestMapping(value = "/person/profile/{id}/{name}/{status}", method = RequestMethod.GET)
    public @ResponseBody
    LoginInfo loginSession(@PathVariable int id, @PathVariable String name,
            @PathVariable boolean status) {

        return new LoginInfo(id, name, status);
    }
//	public LoginResponse loginSession(LoginInfo loginInfo) {
//
//		return null;
//	}
//
    @RequestMapping(value = "/person/login", method = RequestMethod.POST)
    public @ResponseBody
    LoginInfo login(@RequestBody LoginInfo person) {
        return person;
    }

    @RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public LoginInfo getPet(@PathVariable String petId, Model model) {
        // implementation omitted
	//	ConferenceDaoImpl conferenceDaoImpl =  new ConferenceDaoImpl();
		Conference domain = new Conference();
		domain.setBillingcode(1000);

		domain.setConferencename("潘祖继的会议");
		domain.setConfscale(100);
		domain.setPcode1(1);
		domain.setPcode2(2);
		domain.setProductid(20);
		domain.setConfigstr("configstr");
		//userServcie.save(domain);
		//conferenceDaoImpl.update(domain);
		//confDao.save(domain);

    //	UserDetails user = userServcie.loadUserByUsername("test");

    	String str =userServcie.getClass().getName();
    	 return new LoginInfo(1,str,false);
    }

	public NullResponse logoutSession() {
		return null;
	}


	/**
	 * 接收客户端发送的JSON数据，并将其转换为对象
	 * @RequestBody
	 * 其一，从http请求报文的请求体中获取JSON数据，则说明必须是POST请求
	 * 其二，Body中为JSON，则最可能为Ajax请求，通过form进行post请求好像办不到呢
	 */
	@RequestMapping(value="login", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public LoginInfo jsonPost(@RequestBody LoginInfo user) {
		System.out.println("ajax json post");
		System.out.println(user.getId());
		System.out.println(user.getName());
		user.setId(99999);
		user.setName("todd");
		return user;
	}
//	@RequestMapping("/something")
//	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
//	    String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader"));
//	    byte[] requestBody = requestEntity.getBody();
//
//	    // do something with request header and body
//
//	    HttpHeaders responseHeaders = new HttpHeaders();
//	    responseHeaders.set("MyResponseHeader", "MyValue");
//	    return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
//	}
}
