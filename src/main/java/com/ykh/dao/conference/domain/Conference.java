package com.ykh.dao.conference.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

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
public class Conference implements GrantedAuthority,CacheDomain,Request<Conference>{
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
	private Integer conferenceid;
	private Integer productid;
	private String  conferencename;
	private Integer billingcode;
	private Integer confscale;
	private Integer pcode1;
	private Integer pcode2;
	private String  configstr;


	public Object getId() {
		// TODO Auto-generated method stub
		return conferenceid;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	public Integer getConfscale() {
		return confscale;
	}

	public void setConfscale(Integer confscale) {
		this.confscale = confscale;
	}

	public Integer getPcode1() {
		return pcode1;
	}

	public void setPcode1(Integer pcode1) {
		this.pcode1 = pcode1;
	}

	public Integer getPcode2() {
		return pcode2;
	}

	public void setPcode2(Integer pcode2) {
		this.pcode2 = pcode2;
	}

	public String getConfigstr() {
		return configstr;
	}

	public void setConfigstr(String configstr) {
		this.configstr = configstr;
	}

}
