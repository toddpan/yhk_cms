package com.ykh.dao;

<<<<<<< HEAD
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import javax.persistence.Transient;
=======
import javax.persistence.Transient;

import com.google.common.collect.Lists;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


>>>>>>> upstream/master
/**
 * 分页，利用jpa的自带分页
 * @author ant_shake_tree
 *
 * @param <T>
 */

public class PageRequest<T> implements Request,Serializable{

	@Transient
	private int pageSize = 15;
	@Transient
	private  int currentpage=1;

	@Transient
	private Map<String,Sort.Direction> orders;

	private static final long serialVersionUID = 1232825578694716871L;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public Map<String, Sort.Direction> getOrders() {
		return orders;
	}

	public void setOrders(Map<String, Sort.Direction> orders) {
		this.orders = orders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PageRequest)) return false;

		PageRequest<?> that = (PageRequest<?>) o;

		if (getPageSize() != that.getPageSize()) return false;
		if (getCurrentpage() != that.getCurrentpage()) return false;
		return !(getOrders() != null ? !getOrders().equals(that.getOrders()) : that.getOrders() != null);

	}

	@Override
	public int hashCode() {
		int result = getPageSize();
		result = 31 * result + getCurrentpage();
		result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
		return result;
	}
}
