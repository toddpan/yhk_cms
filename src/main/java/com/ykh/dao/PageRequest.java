package com.ykh.dao;

import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
/**
 * 暂时用不到
 * @author ant_shake_tree
 *
 * @param <V>
 */
@JsonSerialize(include=Inclusion.NON_DEFAULT)
public class PageRequest<V> implements Request<V> {
	@Transient
	private String sortkey;
	@Transient
	private int ascend;
	@Transient
	private int pagesize = 15;
	@Transient
	private int page = 1;
	@Transient
	private int amount;
	public String getSortkey() {
		return sortkey;
	}

	public void setSortkey(String sortkey) {
		this.sortkey = sortkey;
	}
	public int getAscend() {
		return ascend;
	}

	public void setAscend(int ascend) {
		this.ascend = ascend;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
