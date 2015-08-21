package com.ykh.dao.suport;//package com.hm.engine.dao.suport;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
////import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.stereotype.Repository;
////import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.hm.engine.dao.Dao;
//import com.hm.engine.dao.GenericsUtils;
//import com.hm.engine.dao.Request;
//
///**
// *
// * @author ant_shake_tree
// *
// * @param <T>
// */
//@Repository("daoSuport")
//public  class JPADaoSuport<T> implements Dao<T> {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//
//
//
//
//	public EntityManager getEntityManager() {
//		return entityManager;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Transactional(readOnly = true)
//	public List<T> listRequest(Request<T> req) {
//		List<T> ls = null;
//		QueryUtil queryUtil = QueryUtil.getHqlByDomain(req);
//
//		String hql = queryUtil.getHql();
//		List<Object> args = queryUtil.getValues();
//		Query query = entityManager.createQuery(hql);
//
//
//		ls = JPADaoSuport.prepareParamlizedQuery(query, args.toArray())
//				.getResultList();
//
//		return ls;
//	}
//
//	@Override
//	public T findOne(Request<T> req) {
//		QueryUtil queryUtil = QueryUtil.getHqlByDomain(req);
//		List<T> ls = this.findHql(queryUtil.getHql(), queryUtil.getValues().toArray());
//		if (ls.size() > 0) {
//			return ls.get(0);
//		} else {
//			return null;
//		}
//	}
//
//	public int getCount(String hql, List<Object> values) {
//		if (hql.contains("select")) {
//			hql = hql.substring(hql.indexOf("from"));
//		}
//		Query q = this.entityManager.createQuery("select count(*) " + hql);
//		return prepareParamlizedQuery(q, values.toArray()).getFirstResult();
//	}
//
//	private static Query prepareParamlizedQuery(final Query query,
//			final Object... params) {
//		if (params == null) {
//			return query;
//		}
//		int i = 0;
//
//		for (Object param : params) {
//			if (param == null) {
//				continue;
//			}
//			query.setParameter(++i, param);
//		}
//		return query;
//	}
//
//
//
//	@Override
//	public T get(Class<T> clazz, Serializable identity) {
//		return this.entityManager.find(clazz, identity);
//	}
//
//	@Transactional
//	@Override
//	public T update(T domain) {
//		return this.entityManager.merge(domain);
//	}
//
//	// @Transactional(readOnl)
//	@javax.transaction.Transactional
//	@Override
//	public void delete(T domain) {
//		this.entityManager.remove(entityManager.merge(domain));
//	}
//
//	public void excuteNative(String hql, Object... args) {
//		prepareParamlizedQuery(this.entityManager.createNativeQuery(hql), args)
//				.executeUpdate();
//	}
//
//	@Transactional
//	public void excuteHql(String hql, Object... args) {
//		prepareParamlizedQuery(this.entityManager.createQuery(hql), args)
//				.executeUpdate();
//	}
//
//	@Override
//	@Transactional
//	public void deleteByIds(Class<T> clazz, Serializable... identities) {
//		if (identities == null) {
//			return;
//		}
//		for (Serializable identity : identities) {
//			this.delete(get(clazz, identity));
//		}
//	}
//
//	@Override
//	public void save(Object t) {
//		this.entityManager.persist(t);
//	}
//
//	@SuppressWarnings("unchecked")
//	Class<T> clazz = GenericsUtils.getSuperClassGenricType(getClass());
//
//	public Class<T> getClazz() {
//		return clazz;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public T findOneByKey(String filedName, Object key) {
//
//		// entityManager.find(arg0, arg1)
//		try {
//			return (T) this.entityManager
//					.createQuery(
//							"from " + this.clazz.getSimpleName() + " where "
//									+ filedName + " =?").setParameter(1, key)
//					.getResultList().get(0);
//		} catch (Exception e) {
//			return null;
//		}
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Transactional(readOnly = true)
//	public List<T> findAll() {
//		Query q = this.entityManager.createQuery("from  "
//				+ this.clazz.getSimpleName());
//		return (List<T>) q.getResultList();
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	@Transactional(readOnly = true)
//	public List<T> findHql(String hql, Object... args) {
//		return ((List<T>) prepareParamlizedQuery(
//				this.entityManager.createQuery(hql), args).getResultList());
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public T find(Object id) {
//		return this.entityManager.find(this.clazz, id);
//	}
//
//	@Override
//	public T findOne(String hql, Object... keys) {
//		List<T> ls = this.findHql(hql, keys);
//		if (ls.size() > 0) {
//			return ls.get(0);
//		} else {
//			return null;
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Object> findAllSql(String hql, Object... args) {
//		return prepareParamlizedQuery(
//				this.entityManager.createNativeQuery(hql), args)
//				.getResultList();
//	}
//
//	@Override
//	@Transactional
//	public void merge(T domain) {
//		this.entityManager.merge(domain);
//	}
//
//
//
//
//}
