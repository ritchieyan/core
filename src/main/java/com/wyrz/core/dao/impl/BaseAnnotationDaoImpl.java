package com.wyrz.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wyrz.core.dao.BaseDao;
import com.wyrz.core.dao.demain.Identifiable;
import com.wyrz.core.exception.DaoException;
import com.wyrz.core.mapper.BaseMapper;
import com.wyrz.core.utils.BeanUtils;
import com.wyrz.core.utils.QueryParamsCreator;

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

	@Autowired
	private QueryParamsCreator<T> queryParamsCreator;

	/**
	 * 获取WritableMapper实例
	 *  ---该Mapper继承BaseMapper
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日上午11:35:28
	 */
	protected abstract <I extends BaseMapper<T, ? extends T>> I getWritableMapper();

	/**
	 * 获取ReadonlyMapper实例
	 *  ---该Mapper继承BaseMapper
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日上午11:35:28
	 */
	protected abstract <I extends BaseMapper<T, ? extends T>> I getReadonlyMapper();

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> V selectOne(T query) {
		try {
			Assert.notNull(query);
			Map<String, Object> params = BeanUtils.toMap(query);
			return (V) this.getReadonlyMapper().selectOne(params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！"), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> V selectById(Integer id) {
		try {
			Assert.notNull(id);
			return (V) this.getReadonlyMapper().selectById(id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！"), e);
		}
	}

	@Override
	public List<Integer> selectAllId() {
		try {
			return this.getReadonlyMapper().selectAllId();
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有ID号列表出错！"), e);
		}
	}

	@Override
	public List<Integer> selectIdList(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.getReadonlyMapper().selectIdList(params);
		} catch (Exception e) {
			throw new DaoException(String.format("条件查询ID号列表出错！"), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> List<V> selectList(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return (List<V>) this.getReadonlyMapper().selectList(params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！"), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> List<V> selectAll() {
		try {
			return (List<V>) this.getReadonlyMapper().selectAll();
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有对象列表出错！"), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> List<V> selectByIdList(List<Integer> idList) {
		try {
			if (CollectionUtils.isEmpty(idList)) {
				return null;
			}
			return (List<V>) this.getReadonlyMapper().selectByIdList(idList);
		} catch (Exception e) {
			throw new DaoException(String.format("查询指定ID的记录对象列表出错！"), e);
		}
	}

	// @Override
	// public <K, V extends T> Map<K, V> selectMap(T query, String mapKey) {
	// try {
	// Assert.notNull(mapKey, "[mapKey] - must not be null!");
	// Map<String, Object> params = BeanUtils.toMap(query);
	// params.put("mapKey", mapKey);
	// return this.getReadonlyMapper().selectMap(params);
	// } catch (Exception e) {
	// throw new DaoException(String.format("查询对象Map时出错！"), e);
	// }
	// return null;
	// }

	/**
	 * 获取分页查询参数
	 * 
	 * @author Ritchieyan
	 * @param query 查询对象
	 * @param pageable 分页对象
	 * @return Map 查询参数
	 * @date 2014年12月13日下午9:31:19
	 */
	protected Map<String, Object> getParams(T query, Pageable pageable) {
		return this.queryParamsCreator.create(query, pageable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V extends T> List<V> selectList(T query, Pageable pageable) {
		try {
			return (List<V>) this.getReadonlyMapper().selectList(getParams(query, pageable));
		} catch (Exception e) {
			throw new DaoException(String.format("根据分页对象查询列表出错！"), e);
		}
	}

	// @Override
	// public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable) {
	// try {
	// Map<String, Object> params = getParams(query, pageable);
	// params.put("mapKey", mapKey);
	// return this.getReadonlyMapper().selectMap(params);
	// } catch (Exception e) {
	// throw new DaoException(String.format("根据分页对象查询列表出错！"), e);
	// }
	// return null;
	// }

	@Override
	public Long selectCount() {
		try {
			return this.getReadonlyMapper().selectAllCount();
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！"), e);
		}
	}

	@Override
	public Long selectCount(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.getReadonlyMapper().selectCount(params);
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
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.getWritableMapper().delete(params);
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
