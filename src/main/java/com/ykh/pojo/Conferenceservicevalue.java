//package com.ykh.pojo;
//
//import com.sun.xml.bind.CycleRecoverable;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// * Conferenceservicevalue generated by MyEclipse Persistence Tools
// */
//@XmlRootElement
//public class Conferenceservicevalue implements java.io.Serializable, CycleRecoverable {
//
//	// Fields
//
//	private static final long serialVersionUID = 1L;
//	private Integer conferenceservicevalueid;
//	private Servicelibvalue servicelibvalue;
////	private Conferenceservice conferenceservice;
//	private Integer conferenceserviceid;
//
//	// Constructors
//
//	/** default constructor */
//	public Conferenceservicevalue() {
//	}
//
//	/** minimal constructor */
//	public Conferenceservicevalue(Servicelibvalue servicelibvalue) {
//		this.servicelibvalue = servicelibvalue;
//	}
//
////	/** full constructor */
////	public Conferenceservicevalue(Servicelibvalue servicelibvalue, Conferenceservice conferenceservice) {
////		this.servicelibvalue = servicelibvalue;
//////		this.conferenceservice = conferenceservice;
////	}
//
//	@Override
//	public Object onCycleDetected(Context context) {
//		Conferenceservicevalue tempConfservicevalue = new Conferenceservicevalue();
//		tempConfservicevalue.setConferenceservicevalueid(conferenceservicevalueid);
//		return tempConfservicevalue;
//	}
//
//	// Property accessors
//	public int hashCode() {
//
//		int result = 179;
//		result = 37 * result + (conferenceservicevalueid == null ? System.identityHashCode(this) : conferenceservicevalueid.hashCode());
//		return result;
//	}
//	public Integer getConferenceservicevalueid() {
//		return this.conferenceservicevalueid;
//	}
//
//	public void setConferenceservicevalueid(Integer conferenceservicevalueid) {
//		this.conferenceservicevalueid = conferenceservicevalueid;
//	}
//
//	@XmlElement(name="servicelibvalue")
//	public Servicelibvalue getServicelibvalue() {
//		return this.servicelibvalue;
//	}
//
//	public void setServicelibvalue(Servicelibvalue servicelibvalue) {
//		this.servicelibvalue = servicelibvalue;
//	}
//
//	public Integer getConferenceserviceid() {
//		return conferenceserviceid;
//	}
//
//	public void setConferenceserviceid(Integer conferenceserviceid) {
//		this.conferenceserviceid = conferenceserviceid;
//	}
//
////	@XmlElement(name="conferenceservice")
////	public Conferenceservice getConferenceservice() {
////		return this.conferenceservice;
////	}
////
////	public void setConferenceservice(Conferenceservice conferenceservice) {
////		this.conferenceservice = conferenceservice;
////	}
//
//}