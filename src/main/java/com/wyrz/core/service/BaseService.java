package com.wyrz.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wyrz.core.dao.demain.Identifiable;

/**
 * 基础的Service接口
 * @author yanziqi
 * @date 2014年12月9日下午4:36:21
 */
public interface BaseService<T extends Identifiable> {

	/**
	 * 查询一个对象，如果返回的结果多于一个对象将会抛出TooManyResultsException
	 * @author yanziqi
	 * @param query 查询对象，不能为null
	 * @return Mapper中映射的对象，继承自 T对象，一般是Vo对象
	 * @date 2014年12月9日下午4:39:47
	 */
	public <V extends T> V queryOne(T query);

	/**
	 * 通过Id查询一个对象，如果id为null这会抛出IllegalArgumentException异常
	 * @author yanziqi
	 * @param id 主键，不能为null
	 * @return 结果对象，如果未找到返回null
	 * @date 2014年12月9日下午4:40:51
	 */
	public <V extends T> V queryById(String id);

	/**
	 * 查询对象列表
	 * @author yanziqi
	 * @param query query 查询参数，如果未null则查询所有，相当于调用方法{@link com.wyrz.core.dao.BaseDao.selectAll }
	 * @return 结果对象列表
	 * @date 2014年12月9日下午4:50:42
	 */
	public <V extends T> List<V> queryList(T query);

	/**
	 * 查询所有记录ID号列表
	 * @author yanziqi
	 * @return ID号列表
	 * @date 2014年12月9日下午4:52:11
	 */
	public List<String> queryAllId();

	/**
	 * 条件查询ID号列表
	 * @author yanziqi
	 * @param query 查询条件
	 * @return ID号列表
	 * @date 2014年12月9日下午4:54:14
	 */
	public List<String> queryIdList(T query);

	/**
	 * 查询指定ID列表的记录
	 * @author yanziqi
	 * @param idList id号列表，若为null或空列表则直接返回null值
	 * @return
	 * @date 2014年12月9日下午4:54:34
	 */
	public <V extends T> List<V> queryByIdList(List<String> idList);

	/**
	 * 查询所有记录列表
	 * @author yanziqi
	 * @return List 结果列表
	 * @date 2014年12月9日下午4:55:32
	 */
	public <V extends T> List<V> queryAll();

	/**
	 * 根据结果集中的一列作为key，将结果集转换成Map
	 * @author yanziqi
	 * @param <K> 返回Map的key类型
	 * @param <V> 返回Map的Value类型
	 * @param query 查询参数,如果未null则查询所有对象
	 * @param mapKey 返回结果List中‘mapKey’属性值作为Key (The property to use as key for each value in the list.)
	 * @return Map 包含key属性值的Map对象
	 * @date 2014年12月9日下午4:55:55
	 */
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey);

	/**
	 * 查询总记录数
	 * @author yanziqi
	 * @return 记录总数
	 * @date 2014年12月9日下午4:56:15
	 */
	public Long queryCount();

	/**
	 * 查询记录数
	 * @author yanziqi
	 * @param query 查询对象，如果为null，则查询对象总数
	 * @return 记录总数
	 * @date 2014年12月9日下午4:56:50
	 */
	public Long queryCount(T query);

	/**
	 * 添加对象,如果要添加的对象没有设置Id或者Id为空字符串或者是空格，则添加数据之前会调用 generateId()方法设置Id
	 * @author yanziqi
	 * @param entity 要实例化的实体，不能为null
	 * @date 2014年12月9日下午4:57:12
	 */
	public void insert(T entity);

	/**
	 * 删除对象
	 * @author yanziqi
	 * @param query 要删除的实体对象，不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午4:57:44
	 */
	public int delete(T query);

	/**
	 * 根据Id删除对象
	 * @author yanziqi
	 * @param id 要删除的ID，不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午4:58:08
	 */
	public int deleteById(String id);

	/**
	 * 删除所有
	 * @author yanziqi
	 * @return 受影响结果数
	 * @date 2014年12月9日下午4:58:32
	 */
	public int deleteAll();

	/**
	 * 更新对象，对象必须设置ID
	 * @author yanziqi
	 * @param entity 实体的Id不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午4:58:52
	 */
	public int updateById(T entity);

	/**
	 * 更新对象中已设置的字段，未设置的字段不更新
	 * @author yanziqi
	 * @param entity 要更新的实体对象，不能为null，切ID必须不为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午4:59:11
	 */
	public int updateByIdSelective(T entity);

	/**
	 * 根据id，批量删除记录，如果传入的列表为null或为空列表则直接返回
	 * @author yanziqi
	 * @param idList 批量删除ID列表
	 * @date 2014年12月9日下午4:59:32
	 */
	public void deleteByIdInBatch(List<String> idList);

	/**
	 * 批量插入，如果为空列表则直接返回
	 * @author yanziqi
	 * @param entityList 需要批量插入的实体对象列表
	 * @date 2014年12月9日下午5:00:45
	 */
	public void insertInBatch(List<T> entityList);

	/**
	 * 批量更新，改方法根据实体ID更新已设置的字段，未设置的字段不更新
	 * @author yanziqi
	 * @param entityList 批量更新的实体对象列表
	 * @date 2014年12月9日下午5:00:57
	 */
	public void updateInBatch(List<T> entityList);

	/**
	 * <pre>查询对象列表，注意：在给定非null的分页对象时该方法自动设置分页总记录数,如果query和pageable同时为null则查询所有</pre>
	 * @author yanziqi
	 * @param query 查询参数
	 * @param pageable 分页对象
	 * @return List 根据分页对象查询的分页结果列表
	 * @date 2014年12月9日下午5:01:12
	 */
	public <V extends T> List<V> queryList(T query, Pageable pageable);

	/**
	 * <pre>查询对象列表，注意：在给定非null的分页对象时该方法自动设置分页总记录数,如果query和pageable同时为null则查询所有</pre>
	 * @author yanziqi
	 * @param query 查询参数
	 * @param pageable 分页对象
	 * @return Page 信息方便前台显示
	 * @date 2014年12月9日下午5:02:06
	 */
	public <V extends T> Page<V> queryPageList(T query, Pageable pageable);

	/**
	 * 根据结果集中的一列作为key，将结果集转换成Map
	 * @author yanziqi
	  * @param <K> 返回Map的key类型
	 * @param <V> 返回Map的Value类型
	 * @param query 查询参数
	 * @param mapKey 返回结果List中‘mapKey’属性值作为Key (The property to use as key for each value in the list.)
	 * @param page 分页对象
	 * @return Map containing key pair data. 
	 * @date 2014年12月9日下午5:04:13
	 */
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey, Pageable pageable);
}
