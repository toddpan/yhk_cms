package com.ykh.dao.conference.domain;
import java.util.*;

import javax.persistence.*;

import com.alibaba.fastjson.JSON;
import com.ykh.common.ParseJSON;
//import com.ykh.pojo.Product;
import com.ykh.tang.agent.vo.AutoStopParams;
import com.ykh.tang.agent.vo.RoleInfo;
import com.ykh.tang.agent.vo.SubConferenceInfo;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;

import com.ykh.common.cache.CacheDomain;
import com.ykh.dao.Request;
/**
 * ClassName: Conference
 * :
 * @author todd
 * @date 2013-2-3 上午1:07:59
 */
@Entity
public class Conference implements CacheDomain,Request<Conference>{
	/**
	 * serialVersionUID:
	 * @since JDK 1.7
	 */
	/*
	+-------------------+--------------+------+-----+-------------------+-----------------------------+
	| Field             | Type         | Null | Key | Default           | Extra                       |
	+-------------------+--------------+------+-----+-------------------+-----------------------------+
	| conferenceid      | int(11)      | NO   | PRI | NULL              | auto_increment              |
	| productid         | int(11)      | YES  | MUL | NULL              |                             |
	| billingcode       | varchar(200) | YES  | UNI | NULL              |                             |
	| conferencename    | varchar(200) | YES  |     | NULL              |                             |
	| conferencedesc    | varchar(200) | YES  |     | NULL              |                             |
	| password          | varchar(200) | YES  |     | NULL              |                             |
	| starttime         | datetime     | YES  |     | NULL              |                             |
	| conferenceminutes | int(11)      | YES  |     | NULL              |                             |
	| reservtime        | datetime     | YES  |     | NULL              |                             |
	| noticetime        | int(11)      | YES  |     | NULL              |                             |
	| valid             | int(11)      | YES  |     | NULL              |                             |
	| confscale         | int(11)      | YES  |     | NULL              |                             |
	| cycle             | int(11)      | YES  |     | NULL              |                             |
	| pin               | tinyint(1)   | YES  |     | NULL              |                             |
	| callout           | tinyint(1)   | YES  |     | NULL              |                             |
	| realreserve       | tinyint(1)   | YES  |     | NULL              |                             |
	| language          | int(11)      | YES  |     | NULL              |                             |
	| roles             | varchar(200) | YES  |     | NULL              |                             |
	| time1             | int(11)      | YES  |     | NULL              |                             |
	| stopwhenoneuser   | tinyint(1)   | YES  |     | 0                 |                             |
	| time2             | int(11)      | YES  |     | NULL              |                             |
	| ifpasswordfixed   | tinyint(1)   | YES  |     | 0                 |                             |
	| updatetime        | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
	| pcode1            | varchar(50)  | YES  |     | NULL              |                             |
	| pcode2            | varchar(50)  | YES  |     | NULL              |                             |
	| confscalePSTN     | int(11)      | YES  |     | NULL              |                             |
	| useResv           | char(1)      | YES  |     | N                 |                             |
	| isRecovered       | tinyint(1)   | YES  |     | 0                 |                             |
	| bridgeName        | varchar(20)  | NO   |     | summit2           |                             |
	| cmsbridge         | varchar(10)  | YES  |     | NULL              |                             |
	+-------------------+--------------+------+-----+-------------------+-----------------------------+
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer conferenceId;
	@Transient
	private Integer tempConferenceId;
// Fields

	private static final long serialVersionUID = 15679L;

	private String conferencedesc;
	private Integer conferenceminutes;
	private Date reservtime;
	private Integer noticetime;
	private Integer valid = 0;	//初始值
	private Integer cycle;
	private Boolean pin;
	private Boolean callout;
	private Boolean realreserve;
	private Integer language;
	private Integer recordType; //0 – 外部录音 1 – 内部录音
	private String  conferencename;
	private String billingcode;
//	@Transient
//	private Product product;
	private String roles;

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Convert(converter = JpaConverterJson.class)
	private AutoStopParams autoStopParams;
	private  String password;
	private  Integer confScale;
	@Convert(converter = ListServiceConfigConverJson.class)
	private ServiceConfig serviceConfigs;
	@Convert(converter = ListRuleInfoConverJson.class)
	private RuleInfoBody ruleInfos;
	@Transient
	public Object getId() {
		return conferenceId;
	}
	@Transient
	private Date starttime;

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
//	SubConferenceInfo subConfInfo = new SubConferenceInfo();

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getConferenceId() {
		return conferenceId;
	}

	public void setConferenceId(Integer conferenceId) {
		this.conferenceId = conferenceId;
	}


	public String getConferencename() {
		return conferencename;
	}

	public void setConferencename(String conferencename) {
		this.conferencename = conferencename;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public String getConferencedesc() {
		return conferencedesc;
	}

	public void setConferencedesc(String conferencedesc) {
		this.conferencedesc = conferencedesc;
	}

	public Integer getConferenceminutes() {
		return conferenceminutes;
	}

	public void setConferenceminutes(Integer conferenceminutes) {
		this.conferenceminutes = conferenceminutes;
	}

	public Date getReservtime() {
		return reservtime;
	}

	public void setReservtime(Date reservtime) {
		this.reservtime = reservtime;
	}

	public Integer getNoticetime() {
		return noticetime;
	}

	public void setNoticetime(Integer noticetime) {
		this.noticetime = noticetime;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}



	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Boolean getPin() {
		return pin;
	}

	public void setPin(Boolean pin) {
		this.pin = pin;
	}

	public Boolean getCallout() {
		return callout;
	}

	public void setCallout(Boolean callout) {
		this.callout = callout;
	}

	public Boolean getRealreserve() {
		return realreserve;
	}

	public void setRealreserve(Boolean realreserve) {
		this.realreserve = realreserve;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public String getBillingcode() {
		return billingcode;
	}

	public void setBillingcode(String billingcode) {
		this.billingcode = billingcode;
	}

	public AutoStopParams getAutoStopParams() {
		return autoStopParams;
	}

	public void setAutoStopParams(AutoStopParams autoStopParams) {
		this.autoStopParams = autoStopParams;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getConfScale() {
		return confScale;
	}

	public void setConfScale(Integer confScale) {
		this.confScale = confScale;
	}



	public static class JpaConverterJson implements AttributeConverter<Object, String> {


		@Override
		public String convertToDatabaseColumn(Object meta) {
			try {
				return ParseJSON.toJson(meta);
			} catch (Exception ex) {
				return null;

			}
		}

		@Override
		public AutoStopParams convertToEntityAttribute(String dbData) {
			try {
				return ParseJSON.fromJson(dbData, AutoStopParams.class);
			} catch (Exception ex) {
				return null;
			}
		}

	}
	public  static  class  ListServiceConfigConverJson implements AttributeConverter<ServiceConfig,String>{

		@Override
		public String convertToDatabaseColumn(ServiceConfig attribute) {
			return JSON.toJSONString(attribute);
		}

		@Override
		public ServiceConfig convertToEntityAttribute(String dbData) {
			return JSON.parseObject(dbData,ServiceConfig.class);
		}
	}	public  static  class  ListRuleInfoConverJson implements AttributeConverter<RuleInfoBody,String>{

		@Override
		public String convertToDatabaseColumn(RuleInfoBody attribute) {
			return JSON.toJSONString(attribute);
		}

		@Override
		public RuleInfoBody convertToEntityAttribute(String dbData) {
			return JSON.parseObject(dbData,RuleInfoBody.class);
		}
	}

	public Integer getTempConferenceId() {
		return tempConferenceId;
	}
	public static class ServiceConfig{
		private List<String> serviceConfigs = null;

		public List<String> getServiceConfigs() {
			return serviceConfigs;
		}

		public void setServiceConfigs(List<String> serviceConfigs) {
			this.serviceConfigs = serviceConfigs;
		}
	}
	public  static class   RuleInfoBody{
		private List<RoleInfo> roleInfo = null;

		public List<RoleInfo> getRoleInfo() {
			return roleInfo;
		}

		public void setRoleInfo(List<RoleInfo> roleInfo) {
			this.roleInfo = roleInfo;
		}
	}

	public ServiceConfig getServiceConfigs() {
		return serviceConfigs;
	}

	public void setServiceConfigs(ServiceConfig serviceConfigs) {
		this.serviceConfigs = serviceConfigs;
	}

	public RuleInfoBody getRuleInfos() {
		return ruleInfos;
	}

	public void setRuleInfos(RuleInfoBody ruleInfos) {
		this.ruleInfos = ruleInfos;
	}

	public void setTempConferenceId(Integer tempConferenceId) {
		this.tempConferenceId = tempConferenceId;
	}
}
