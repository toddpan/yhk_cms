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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ant_shake_tree
 * @version 
 * @since JDK 1.7
 */
@NoRepositoryBean
public interface Dao<T,ID extends Serializable> extends JpaRepository<T,ID> {


	public  List<T> listRequest(Request<T> request);

	public void excuteNative(String hql, Object... args);
	public void excuteHql(String hql, Object... args);
	public List<T> findHql(String hql, Object... args);
	public List<Object> findAllSql(String hql, Object... args);
	T findOne(Request<T> req);
	T findOne(String hql, Object... args);
	T find(ID id);
	public int getCount(String hql, Object... values);
}
