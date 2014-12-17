package com.wyrz.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wyrz.core.dao.BaseDao;
import com.wyrz.core.dao.demain.Identifiable;
import com.wyrz.core.exception.DaoException;
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

	@Override
	public <V extends T> V selectOne(T query) {
		try {
			Assert.notNull(query);
			return this.getReadonlyMapper().selectOne(query);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！"), e);
		}
	}

	@Override
	public <V extends T> V selectById(Integer id) {
		try {
			Assert.notNull(id);
			return this.getReadonlyMapper().selectById(id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！"), e);
		}
	}

	@Override
	public List<String> selectAllId() {
		try {
			return this.getReadonlyMapper().selectAllId();
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有ID号列表出错！"), e);
		}
	}

	@Override
	public List<String> selectIdList(T query) {
		try {
			return this.getReadonlyMapper().selectIdList(query);
		} catch (Exception e) {
			throw new DaoException(String.format("条件查询ID号列表出错！"), e);
		}
	}

	@Override
	public <V extends T> List<V> selectList(T query) {
		try {
			Assert.notNull(query);
			return this.getReadonlyMapper().selectList(query);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！"), e);
		}
	}

	@Override
	public <V extends T> List<V> selectAll() {
		try {
			return this.getReadonlyMapper().selectAll();
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有对象列表出错！语句：%s"), e);
		}
	}

	@Override
	public <V extends T> List<V> selectByIdList(List<Integer> idList) {
		try {
			if (CollectionUtils.isEmpty(idList)) {
				return null;
			}
			return this.getReadonlyMapper().selectByIdList(idList);
		} catch (Exception e) {
			throw new DaoException(String.format("查询指定ID的记录对象列表出错！"), e);
		}
	}

	@Override
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey) {
		try {
			Assert.notNull(mapKey, "[mapKey] - must not be null!");
			return this.getReadonlyMapper().selectMap(query, mapKey);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象Map时出错！"), e);
		}
	}

	@Override
	public <V extends T> List<V> selectList(T query, Pageable pageable) {
		try {
			return this.getReadonlyMapper().selectList(query, pageable);
		} catch (Exception e) {
			throw new DaoException(String.format("根据分页对象查询列表出错！"), e);
		}
	}

	@Override
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable) {
		try {
			return this.getReadonlyMapper().selectMap(query, mapKey, pageable);
		} catch (Exception e) {
			throw new DaoException(String.format("根据分页对象查询列表出错！"), e);
		}
	}

	@Override
	public Long selectCount() {
		try {
			return this.getReadonlyMapper().selectCount();
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！"), e);
		}
	}

	@Override
	public Long selectCount(T query) {
		try {
			return this.getReadonlyMapper().selectCount(query);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！"), e);
		}
	}

	@Override
	public void insert(T entity) {
		try {
			Assert.notNull(entity);
			this.getWritableMapper().insert(entity);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！"), e);
		}
	}

	@Override
	public int delete(T query) {
		try {
			Assert.notNull(query);
			return this.getWritableMapper().delete(query);
		} catch (Exception e) {
			throw new DaoException(String.format("删除对象出错！"), e);
		}
	}

	@Override
	public int deleteById(Integer id) {
		try {
			Assert.notNull(id);
			return this.getWritableMapper().deleteById(id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！"), e);
		}
	}

	@Override
	public int deleteAll() {
		try {
			return this.getWritableMapper().deleteAll();
		} catch (Exception e) {
			throw new DaoException(String.format("删除所有对象出错！"), e);
		}
	}

	@Override
	public int updateById(T entity) {
		try {
			Assert.notNull(entity);
			Assert.notNull(entity.getId());
			return this.getWritableMapper().updateById(entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！"), e);
		}
	}

	@Override
	public int updateByIdSelective(T entity) {
		try {
			Assert.notNull(entity);
			Assert.notNull(entity.getId());
			return this.getWritableMapper().updateByIdSelective(entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象某些属性出错！"), e);
		}
	}

	@Override
	@Transactional
	public void deleteByIdInBatch(List<Integer> idList) {
		if (idList == null || idList.isEmpty()) {
			return;
		}
		for (Integer id : idList) {
			this.deleteById(id);
		}
	}

}
