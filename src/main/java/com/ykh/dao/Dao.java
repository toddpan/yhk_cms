/**
 * Project Name:vdi-core-server-lls
 * File Name:Dao.java
 * Package Name:com.vdi.dao
 * Date:2014年7月30日下午4:18:18
 * Copyright (c) 2014 All Rights Reserved.
 *
*/
/**
 * Project Name:vdi-core-server-lls
 * File Name:Dao.java
 * Package Name:com.vdi.dao
 * Date:2014年7月30日下午4:18:18
 * Copyright (c) 2014,  All Rights Reserved.
 *
 */

package com.ykh.dao;

import com.ykh.dao.suport.PageView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ant_shake_tree
 * @version 
 * @since JDK 1.7
 */
@NoRepositoryBean
public interface Dao<T,ID extends Serializable> extends JpaRepository<T,ID> {


	List<T> listRequest(Request<T> request);

	void excuteNative(String hql, Object... args);
	void excuteHql(String hql, Object... args);
	List<T> findHql(String hql, Object... args);
	List<Object> findAllSql(String hql, Object... args);
	T findOne(Request<T> req);
	T findOne(String hql, Object... args);
	T find(ID id);
	PageVO<T> findPages(PageRequest<T> request);

	int getCount(String hql, Object... values);
	class PageVO<T>{
		List<T> contents;
		PageView page;

		public List<T> getContents() {
			return contents;
		}

		public void setContents(List<T> contents) {
			this.contents = contents;
		}

		public PageView getPage() {
			return page;
		}

		public void setPage(PageView page) {
			this.page = page;
		}
	}
}
