package com.ykh.pojo;

/**
 * ProductlibtypeId generated by MyEclipse Persistence Tools
 */

public class Productlibtype implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	private Integer productid;
	private Integer servicelibtypeid;
	private Integer servicelibid;
	private Integer servicelibvalueid;

	// Constructors

	/** default constructor */
	public Productlibtype() {
	}

	/** minimal constructor */
	public Productlibtype(Integer servicelibtypeid, Integer servicelibid, Integer servicelibvalueid) {
		this.servicelibtypeid = servicelibtypeid;
		this.servicelibid = servicelibid;
		this.servicelibvalueid = servicelibvalueid;
	}

	/** full constructor */
	public Productlibtype(Integer productid, Integer servicelibtypeid, Integer servicelibid, Integer servicelibvalueid) {
		this.productid = productid;
		this.servicelibtypeid = servicelibtypeid;
		this.servicelibid = servicelibid;
		this.servicelibvalueid = servicelibvalueid;
	}

	// Property accessors

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getServicelibtypeid() {
		return this.servicelibtypeid;
	}

	public void setServicelibtypeid(Integer servicelibtypeid) {
		this.servicelibtypeid = servicelibtypeid;
	}

	public Integer getServicelibid() {
		return this.servicelibid;
	}

	public void setServicelibid(Integer servicelibid) {
		this.servicelibid = servicelibid;
	}

	public Integer getServicelibvalueid() {
		return this.servicelibvalueid;
	}

	public void setServicelibvalueid(Integer servicelibvalueid) {
		this.servicelibvalueid = servicelibvalueid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Productlibtype))
			return false;
		Productlibtype castOther = (Productlibtype) other;

		return ((this.getProductid() == castOther.getProductid()) || (this.getProductid() != null && castOther.getProductid() != null && this
				.getProductid().equals(castOther.getProductid())))
				&& ((this.getServicelibtypeid() == castOther.getServicelibtypeid()) || (this.getServicelibtypeid() != null
						&& castOther.getServicelibtypeid() != null && this.getServicelibtypeid().equals(castOther.getServicelibtypeid())))
				&& ((this.getServicelibid() == castOther.getServicelibid()) || (this.getServicelibid() != null && castOther.getServicelibid() != null && this
						.getServicelibid().equals(castOther.getServicelibid())))
				&& ((this.getServicelibvalueid() == castOther.getServicelibvalueid()) || (this.getServicelibvalueid() != null
						&& castOther.getServicelibvalueid() != null && this.getServicelibvalueid().equals(castOther.getServicelibvalueid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductid() == null ? 0 : this.getProductid().hashCode());
		result = 37 * result + (getServicelibtypeid() == null ? 0 : this.getServicelibtypeid().hashCode());
		result = 37 * result + (getServicelibid() == null ? 0 : this.getServicelibid().hashCode());
		result = 37 * result + (getServicelibvalueid() == null ? 0 : this.getServicelibvalueid().hashCode());
		return result;
	}

}