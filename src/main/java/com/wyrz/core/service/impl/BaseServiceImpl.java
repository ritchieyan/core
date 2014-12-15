package com.wyrz.core.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.wyrz.core.dao.BaseDao;
import com.wyrz.core.dao.demain.Identifiable;
import com.wyrz.core.exception.DaoException;
import com.wyrz.core.service.BaseService;

/**
 * 
 * @author yanziqi
 * @date 2014年12月9日下午4:37:08
 */
public abstract class BaseServiceImpl<T extends Identifiable> implements BaseService<T> {

	/**
	 * 获取基础数据库操作类
	 * @return
	 */
	protected abstract BaseDao<T> getBaseDao();

	@Override
	public <V extends T> V queryOne(T query) {
		return getBaseDao().selectOne(query);
	}

	@Override
	public <V extends T> V queryById(String id) {
		return getBaseDao().selectById(id);
	}

	@Override
	public <V extends T> List<V> queryList(T query) {
		return getBaseDao().selectList(query);
	}

	@Override
	public <V extends T> List<V> queryAll() {
		return getBaseDao().selectAll();
	}

	@Override
	public List<String> queryAllId() {
		return this.getBaseDao().selectAllId();
	}

	@Override
	public List<String> queryIdList(T query) {
		return this.getBaseDao().selectIdList(query);
	}

	@Override
	public <V extends T> List<V> queryByIdList(List<String> idList) {
		return this.getBaseDao().selectByIdList(idList);
	}

	@Override
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey) {
		return getBaseDao().selectMap(query, mapKey);
	}

	@Override
	public Long queryCount() {
		return getBaseDao().selectCount();
	}

	@Override
	public Long queryCount(T query) {
		return getBaseDao().selectCount(query);
	}

	@Override
	public void insert(T entity) {
		getBaseDao().insert(entity);
	}

	@Override
	public int delete(T query) {
		return getBaseDao().delete(query);
	}

	@Override
	public int deleteById(String id) {
		return getBaseDao().deleteById(id);
	}

	@Override
	public int deleteAll() {
		return getBaseDao().deleteAll();
	}

	@Override
	public int updateById(T entity) {
		return getBaseDao().updateById(entity);
	}

	@Override
	public int updateByIdSelective(T entity) {
		return getBaseDao().updateByIdSelective(entity);
	}

	@Override
	public void deleteByIdInBatch(List<String> idList) {
		getBaseDao().deleteByIdInBatch(idList);
	}

	@Transactional
	@Override
	public void insertInBatch(List<T> entityList) {
		if (CollectionUtils.isEmpty(entityList)) {
			return;
		}
		for (T entity : entityList) {
			this.getBaseDao().insert(entity);
		}
	}

	@Transactional
	@Override
	public void updateInBatch(List<T> entityList) {
		if (CollectionUtils.isEmpty(entityList)) {
			return;
		}
		for (T entity : entityList) {
			this.getBaseDao().updateByIdSelective(entity);
		}
	}

	@Override
	public <V extends T> List<V> queryList(T query, Pageable pageable) {
		return getBaseDao().selectList(query, pageable);
	}

	@Override
	public <V extends T> Page<V> queryPageList(T query, Pageable pageable) {
		try {
			List<V> contentList = getBaseDao().selectList(query, pageable);
			return new PageImpl<V>(contentList, pageable, getBaseDao().selectCount(query));
		} catch (Exception e) {
			throw new DaoException("根据分页对象查询列表出错！语句", e);
		}
	}

	@Override
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey, Pageable pageable) {
		return getBaseDao().selectMap(query, mapKey, pageable);
	}

}
