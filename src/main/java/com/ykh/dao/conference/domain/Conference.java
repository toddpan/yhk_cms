package com.ykh.dao.conference.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.ykh.common.ParseJSON;
import com.ykh.tang.agent.vo.AutoStopParams;
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
	private static final long serialVersionUID = 15679L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer conferenceId;
	private String  conferencename;
	private Integer billingcode;
	@Convert(converter = JpaConverterJson.class)
	private AutoStopParams autoStopParams;
	@Transient
	private Integer applicationId;
	private  String password;
	private  Integer confScale;
	@Transient
	public Object getId() {
		return conferenceId;
	}

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

	public Integer getBillingcode() {
		return billingcode;
	}

	public void setBillingcode(Integer billingcode) {
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

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
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
}
