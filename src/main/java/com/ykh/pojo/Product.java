package com.ykh.pojo;

import com.ykh.dao.conference.domain.Conference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:Product
 * <p>
 * ClassDesc：产品对象（又叫会议模板）
 * 
 * @author dongyu.zhang
 * @version 1.0
 * @since Ver 1.0
 * @Date 2009 Apr 16, 2009 1:39:19 PM
 */
@XmlRootElement
public class Product implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer productid;
	private String productname;
	private Date createtime;
	private String productstatu;
	private Date lastmodifytime;
	private String createby;
	// 模板创建时不需要封装，只为查询时被动级联加载
	private Set<Conference> conferences = new HashSet<Conference>(0);
	// 模板创建时需要主动封装
//	private Set<Conferencerole> conferenceroles = new HashSet<Conferencerole>(0);
	private Set<ProductRole> productroles = new HashSet<ProductRole>(0);
	// 模板创建时需要主动封装
	private Set<Conferenceservice> conferenceservices = new HashSet<Conferenceservice>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
//	public Product(String productname, Date createtime, String productstatu, Date lastmodifytime, String createby, Set<Conference> conferences,
//			Set<Conferencerole> conferenceroles, Set<Conferenceservice> conferenceservices) {
//		this.productname = productname;
//		this.createtime = createtime;
//		this.productstatu = productstatu;
//		this.lastmodifytime = lastmodifytime;
//		this.createby = createby;
//		this.conferences = conferences;
//		this.conferenceroles = conferenceroles;
//		this.conferenceservices = conferenceservices;
//	}
	
	public Product(String productname, Date createtime, String productstatu, Date lastmodifytime, String createby, Set<Conference> conferences,
			Set<ProductRole> productroles, Set<Conferenceservice> conferenceservices) {
		this.productname = productname;
		this.createtime = createtime;
		this.productstatu = productstatu;
		this.lastmodifytime = lastmodifytime;
		this.createby = createby;
		this.conferences = conferences;
		this.productroles = productroles;
		this.conferenceservices = conferenceservices;
	}

	// Property accessors
	public int hashCode() {

		int result = 179;
		result = 37 * result + (productid == null ? System.identityHashCode(this) : productid.hashCode());
		return result;
	}
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getProductstatu() {
		return this.productstatu;
	}

	public void setProductstatu(String productstatu) {
		this.productstatu = productstatu;
	}

	public Date getLastmodifytime() {
		return this.lastmodifytime;
	}

	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}
	
//	@XmlElement(name="conferences")
	@XmlTransient
	public Set<Conference> getConferences() {
		return this.conferences;
	}

	public void setConferences(Set<Conference> conferences) {
		this.conferences = conferences;
	}
	
//	@XmlElement(name="conferenceroles")
//	public Set<Conferencerole> getConferenceroles() {
//		return this.conferenceroles;
//	}
//
//	public void setConferenceroles(Set<Conferencerole> conferenceroles) {
//		this.conferenceroles = conferenceroles;
//	}

	@XmlElement(name="conferenceservices")
	public Set<Conferenceservice> getConferenceservices() {
		return this.conferenceservices;
	}

	public void setConferenceservices(Set<Conferenceservice> conferenceservices) {
		this.conferenceservices = conferenceservices;
	}
	
	@XmlTransient
	public Set<ProductRole> getProductroles() {
		return productroles;
	}

	public void setProductroles(Set<ProductRole> productroles) {
		this.productroles = productroles;
	}

}