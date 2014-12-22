package com.wyrz.core.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wyrz.core.constants.SqlId;
import com.wyrz.core.dao.BaseDao;
import com.wyrz.core.dao.demain.Identifiable;
import com.wyrz.core.exception.DaoException;
import com.wyrz.core.utils.BeanUtils;
import com.wyrz.core.utils.QueryParamsCreator;
import com.wyrz.core.utils.UUIDUtils;

/**
 * Xml方式Dao的实现类
 * @author Ritchieyan
 * @date 2014年12月13日上午11:04:26
 */
public abstract class BaseXmlDaoImpl<T extends Identifiable> implements BaseDao<T> {

	/**
	 * 只写SqlSession
	 */
	@Autowired
	@Qualifier("writableSQLSession")
	protected SqlSession writableSQLSession;

	/**
	 * 只读SqlSession
	 */
	@Autowired
	@Qualifier("readonlySQLSession")
	protected SqlSession readonlySQLSession;
	@Autowired
	private QueryParamsCreator<T> queryParamsCreator;

	public static final String SQLNAME_SEPARATOR = ".";
	/**
	 * SqlMapping命名空间
	 */
	private String sqlNamespace = getDefaultSqlNamespace();

	/**
	 * 获取泛型类型的尸体对象类全名
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日下午9:10:50
	 */
	private String getDefaultSqlNamespace() {
		Class<?> genericClass = BeanUtils.getGenericClass(this.getClass());
		return genericClass == null ? null : genericClass.getName();
	}

	/**
	 * 获取SqlMapping命名空间
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日下午9:12:29
	 */
	public String getSqlNamespace() {
		return sqlNamespace;
	}

	/**
	 * 设置SqlMapping命名空间。以改变默认的SqlMapping命名空间，
	 * 不能滥用此方法随意改变SqlMapping命名空间。
	 * 
	 * @author Ritchieyan
	 * @param sqlNamespace
	 * @date 2014年12月13日下午9:14:39
	 */
	public void setSqlNamespace(String sqlNamespace) {
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
	 * 
	 * @author Ritchieyan
	 * @param simpleSqlName SqlMapping名
	 * @return 组合 了SqlMapping命名空间后的完整SqlMapping名
	 * @date 2014年12月13日下午9:19:45
	 */
	public String getSqlName(String simpleSqlName) {
		return sqlNamespace + SQLNAME_SEPARATOR + simpleSqlName;
	}

	@Override
	public <V extends T> V selectOne(T query) {
		try {
			Assert.notNull(query);
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.readonlySQLSession.selectOne(getSqlName(SqlId.SQL_SELECT), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", getSqlName(SqlId.SQL_SELECT)), e);
		}
	}

	@Override
	public <V extends T> V selectById(Integer id) {
		try {
			Assert.notNull(id);
			return this.readonlySQLSession.selectOne(getSqlName(SqlId.SQL_SELECT_BY_ID), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID查询对象出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_ID)), e);
		}
	}

	@Override
	public List<Integer> selectAllId() {
		try {
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT_ALL_ID));
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有ID号列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT_ALL_ID)), e);
		}
	}

	@Override
	public List<Integer> selectIdList(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT_ID_LIST), params);
		} catch (Exception e) {
			throw new DaoException(String.format("条件查询ID号列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT_ID_LIST)), e);
		}
	}

	@Override
	public <V extends T> List<V> selectList(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT)), e);
		}
	}

	@Override
	public <V extends T> List<V> selectAll() {
		try {
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT));
		} catch (Exception e) {
			throw new DaoException(String.format("查询所有对象列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT)), e);
		}
	}

	@Override
	public <V extends T> List<V> selectByIdList(List<Integer> idList) {
		try {
			if (CollectionUtils.isEmpty(idList)) {
				return null;
			}
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT_BY_ID_LIST), idList);
		} catch (Exception e) {
			throw new DaoException(String.format("查询指定ID的记录对象列表出错！语句：%s", getSqlName(SqlId.SQL_SELECT_BY_ID_LIST)), e);
		}
	}

	// @Override
	// public <K, V extends T> Map<K, V> selectMap(T query, String mapKey) {
	// try {
	// Assert.notNull(mapKey, "[mapKey] - must not be null!");
	// Map<String, Object> params = BeanUtils.toMap(query);
	// return this.readonlySQLSession.selectMap(getSqlName(SqlId.SQL_SELECT), params, mapKey);
	// } catch (Exception e) {
	// throw new DaoException(String.format("查询对象Map时出错！语句：%s", getSqlName(SqlId.SQL_SELECT)), e);
	// }
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

	@Override
	public <V extends T> List<V> selectList(T query, Pageable pageable) {
		try {
			return this.readonlySQLSession.selectList(getSqlName(SqlId.SQL_SELECT), getParams(query, pageable));
		} catch (Exception e) {
			throw new DaoException(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SqlId.SQL_SELECT)), e);
		}
	}

	// @Override
	// public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable) {
	// try {
	// return this.readonlySQLSession.selectMap(getSqlName(SqlId.SQL_SELECT), getParams(query, pageable), mapKey);
	// } catch (Exception e) {
	// throw new DaoException(String.format("根据分页对象查询列表出错！语句:%s", getSqlName(SqlId.SQL_SELECT)), e);
	// }
	// }

	@Override
	public Long selectCount() {
		try {
			return this.readonlySQLSession.selectOne(getSqlName(SqlId.SQL_SELECT_COUNT));
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！语句：%s", getSqlName(SqlId.SQL_SELECT_COUNT)), e);
		}
	}

	@Override
	public Long selectCount(T query) {
		try {
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.readonlySQLSession.selectOne(getSqlName(SqlId.SQL_SELECT_COUNT), params);
		} catch (Exception e) {
			throw new DaoException(String.format("查询对象总数出错！语句：%s", getSqlName(SqlId.SQL_SELECT_COUNT)), e);
		}
	}

	@Override
	public void insert(T entity) {
		try {
			Assert.notNull(entity);
			// if (StringUtils.isBlank(entity.getId())) {
			// entity.setId(generateId());
			// }
			this.writableSQLSession.insert(getSqlName(SqlId.SQL_INSERT), entity);
		} catch (Exception e) {
			throw new DaoException(String.format("添加对象出错！语句：%s", getSqlName(SqlId.SQL_INSERT)), e);
		}
	}

	@Override
	public int delete(T query) {
		try {
			Assert.notNull(query);
			Map<String, Object> params = BeanUtils.toMap(query);
			return this.writableSQLSession.delete(getSqlName(SqlId.SQL_DELETE), params);
		} catch (Exception e) {
			throw new DaoException(String.format("删除对象出错！语句：%s", getSqlName(SqlId.SQL_DELETE)), e);
		}
	}

	@Override
	public int deleteById(Integer id) {
		try {
			Assert.notNull(id);
			return this.writableSQLSession.delete(getSqlName(SqlId.SQL_DELETE_BY_ID), id);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID删除对象出错！语句：%s", getSqlName(SqlId.SQL_DELETE_BY_ID)), e);
		}
	}

	@Override
	public int deleteAll() {
		try {
			return this.writableSQLSession.delete(getSqlName(SqlId.SQL_DELETE));
		} catch (Exception e) {
			throw new DaoException(String.format("删除所有对象出错！语句：%s", getSqlName(SqlId.SQL_DELETE)), e);
		}
	}

	@Override
	public int updateById(T entity) {
		try {
			Assert.notNull(entity);
			// Assert.hasText(entity.getId());
			Assert.notNull(entity.getId());
			return this.writableSQLSession.update(getSqlName(SqlId.SQL_UPDATE_BY_ID), entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象出错！语句：%s", getSqlName(SqlId.SQL_UPDATE_BY_ID)), e);
		}
	}

	@Override
	public int updateByIdSelective(T entity) {
		try {
			Assert.notNull(entity);
			// Assert.hasText(entity.getId());
			Assert.notNull(entity.getId());
			return this.writableSQLSession.update(getSqlName(SqlId.SQL_UPDATE_BY_ID_SELECTIVE), entity);
		} catch (Exception e) {
			throw new DaoException(String.format("根据ID更新对象某些属性出错！语句：%s", getSqlName(SqlId.SQL_UPDATE_BY_ID_SELECTIVE)),
					e);
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

	/**
	 * 生成主键值。 默认使用{@link UUIDUtils#getUUID()}方法
	 * 如果需要生成主键，需要由子类重写此方法根据需要的方式生成主键值。
	 *  
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月13日下午9:38:11
	 */
	protected String generateId() {
		return UUIDUtils.getUUID();
	}

}
