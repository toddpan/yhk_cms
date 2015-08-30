//package com.ykh.pojo;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ProductRole implements java.io.Serializable {
//	private static final long serialVersionUID = 1L;
//
//	private Integer id;
//	private Conferencerole role;
//	private Product product;
//	private Integer maxuser;
//	private Set<Conferenceprivilege> conferenceprivileges = new HashSet<Conferenceprivilege>(0);
//
//	public ProductRole(){}
//
//	public ProductRole(Conferencerole role, Product product, Integer maxuser, Set<Conferenceprivilege> conferenceprivileges) {
//		this.role = role;
//		this.product = product;
//		this.maxuser = maxuser;
//		this.conferenceprivileges = conferenceprivileges;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Conferencerole getRole() {
//		return role;
//	}
//	public void setRole(Conferencerole role) {
//		this.role = role;
//	}
//	public Product getProduct() {
//		return product;
//	}
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//	public Integer getMaxuser() {
//		return maxuser;
//	}
//	public void setMaxuser(Integer maxuser) {
//		this.maxuser = maxuser;
//	}
//	public Set<Conferenceprivilege> getConferenceprivileges() {
//		return conferenceprivileges;
//	}
//	public void setConferenceprivileges(
//			Set<Conferenceprivilege> conferenceprivileges) {
//		this.conferenceprivileges = conferenceprivileges;
//	}
//}
