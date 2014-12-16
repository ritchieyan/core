package com.wyrz.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.wyrz.core.dao.BaseDao;
import com.wyrz.core.dao.demain.Identifiable;
import com.wyrz.core.mapper.BaseMapper;

/**
 * 注解方式Dao的实现类
 * @author Ritchieyan
 * @date 2014年12月13日上午11:03:37
 */

public abstract class BaseAnnotationDaoImpl<T extends Identifiable> implements BaseDao<T> {

	/**
	 * 只写SqlSession
	 */
	@Resource(name = "writableSQLSession")
	protected SqlSession writableSQLSession;

	/**
	 * 只读SqlSession
	 */
	@Resource(name = "readonlySQLSession")
	protected SqlSession readonlySQLSession;

	/**
	 * 获取WritableMapper实例
	 *  ---该Mapper继承BaseMapper
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日上午11:35:28
	 */
	protected abstract BaseMapper<T> getWritableMapper();

	/**
	 * 获取ReadonlyMapper实例
	 *  ---该Mapper继承BaseMapper
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日上午11:35:28
	 */
	protected abstract BaseMapper<T> getReadonlyMapper();

	/**
	 * 获取Mapper接口
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日上午11:56:54
	 */

	@Override
	public <V extends T> V selectOne(T query) {
		return this.getReadonlyMapper().selectOne(query);
	}

	@Override
	public <V extends T> V selectById(Integer id) {
		return this.getReadonlyMapper().selectById(id);
	}

	@Override
	public List<String> selectAllId() {
		return this.getReadonlyMapper().selectAllId();
	}

	@Override
	public List<String> selectIdList(T query) {
		return this.getReadonlyMapper().selectIdList(query);
	}

	@Override
	public <V extends T> List<V> selectList(T query) {
		return this.getReadonlyMapper().selectList(query);
	}

	@Override
	public <V extends T> List<V> selectAll() {
		return this.getReadonlyMapper().selectAll();
	}

	@Override
	public <V extends T> List<V> selectByIdList(List<Integer> idList) {
		return this.getReadonlyMapper().selectByIdList(idList);
	}

	@Override
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey) {
		return this.getReadonlyMapper().selectMap(query, mapKey);
	}

	@Override
	public <V extends T> List<V> selectList(T query, Pageable pageable) {
		return this.getReadonlyMapper().selectList(query, pageable);
	}

	@Override
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable) {
		return this.getReadonlyMapper().selectMap(query, mapKey, pageable);
	}

	@Override
	public Long selectCount() {
		return this.getReadonlyMapper().selectCount();
	}

	@Override
	public Long selectCount(T query) {
		return this.getReadonlyMapper().selectCount(query);
	}

	@Override
	public void insert(T entity) {
		this.getWritableMapper().insert(entity);
	}

	@Override
	public int delete(T query) {
		return this.getWritableMapper().delete(query);
	}

	@Override
	public int deleteById(Integer id) {
		return this.getWritableMapper().deleteById(id);
	}

	@Override
	public int deleteAll() {
		return this.getWritableMapper().deleteAll();
	}

	@Override
	public int updateById(T entity) {
		return this.getWritableMapper().updateById(entity);
	}

	@Override
	public int updateByIdSelective(T entity) {
		return this.getWritableMapper().updateByIdSelective(entity);
	}

	@Override
	@Transactional
	public void deleteByIdInBatch(List<Integer> idList) {
		this.getWritableMapper().deleteByIdInBatch(idList);
	}

}
