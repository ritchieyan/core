package com.wyrz.core.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.wyrz.core.dao.demain.Identifiable;

/**
 * 
 * @author Ritchieyan
 * @date 2014年12月13日上午10:55:07
 */
public interface BaseMapper<T extends Identifiable> {

	/**
	 * 查询一个对象
	 * @author yanziqi
	 * @param query 查询对象，不能为null
	 * @return Mapper中映射的对象，继承自T对象，一般是Vo对象
	 * @date 2014年12月9日下午2:26:14
	 */
	public <V extends T> V selectOne(T query);

	/**
	 * 通过Id查询一个对象
	 * @author yanziqi
	 * @param id 主键，不能为null
	 * @return 结果对象，如果未找到返回null
	 * @date 2014年12月9日下午2:28:05
	 */
	public <V extends T> V selectById(Integer id);

	/**
	 * 查询所有记录ID号列表
	 * @author yanziqi
	 * @return ID号列表
	 * @date 2014年12月9日下午2:28:39
	 */
	public List<String> selectAllId();

	/**
	 * 条件查询ID号列表
	 * @author yanziqi
	 * @param query 查询条件
	 * @return ID号列表
	 * @date 2014年12月9日下午2:29:59
	 */
	public List<String> selectIdList(T query);

	/**
	 *  查询对象列表
	 * @author yanziqi
	 * @param query 查询参数，如果为null则查询所有，相当于调用方法{@link com.wyrz.core.dao.BaseDao.selectAll }
	 * @return 结果对象列表
	 * @date 2014年12月9日下午2:30:24
	 */
	public <V extends T> List<V> selectList(T query);

	/**
	 * 查询所有记录列表
	 * @author yanziqi
	 * @return List 结果列表
	 * @date 2014年12月9日下午2:32:22
	 */
	public <V extends T> List<V> selectAll();

	/**
	 * 查询给定ID号对应的记录列表
	 * @author yanziqi
	 * @param idList id列表，若为null或空列表则直接返回null值
	 * @return 结果列表
	 * @date 2014年12月9日下午2:34:54
	 */
	public <V extends T> List<V> selectByIdList(List<Integer> idList);

	/**
	 * 根据结果集中的一列作为key，将结果集转换成Map
	 * @param <K> 返回Map的key类型
	 * @param <V> 返回Map的Value类型
	 * @param query 查询参数,如果未null则查询所有对象
	 * @param mapKey 返回结果List中‘mapKey’属性值作为Key (The property to use as key for each value in the list.)
	 * @return Map 包含key属性值的Map对象
	 * @date 2014年12月9日下午2:37:06
	 */
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey);

	/**
	 * <pre>查询对象列表，注意：在给定非null的分页对象时该方法自动设置分页总记录数,如果query和pageable同时为null则查询所有</pre>
	 * @author yanziqi
	 * @param query 查询参数
	 * @param pageable 分页对象
	 * @return 根据分页对象查询的分页结果列表
	 * @date 2014年12月9日下午2:58:20
	 */
	public <V extends T> List<V> selectList(T query, Pageable pageable);

	/**
	 * 根据结果集中的一列作为key，将结果集转换成Map
	 * @author yanziqi
	 * @param <K> 返回Map的key类型
	 * @param <V> 返回Map的Value类型
	 * @param query 查询参数
	 * @param mapKey 返回结果List中‘mapKey’属性值作为Key (The property to use as key for each value in the list.)
	 * @param page 分页对象
	 * @return Map containing key pair data. 
	 * @date 2014年12月9日下午3:16:12
	 */
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey, Pageable pageable);

	/**
	 * 查询总记录数
	 * @author yanziqi
	 * @return 记录总数
	 * @date 2014年12月9日下午3:17:25
	 */
	public Long selectCount();

	/**
	 * 查询记录数
	 * @author yanziqi
	 * @param query 查询对象，如果为null，则查询对象总数
	 * @return 记录总数
	 * @date 2014年12月9日下午3:18:26
	 */
	public Long selectCount(T query);

	/**
	 * 添加对象,如果要添加的对象没有设置Id或者Id为空字符串或者是空格，则添加数据之前会调用 generateId()方法设置Id
	 * @author yanziqi
	 * @param entity 
	 * @date 2014年12月9日下午3:18:53
	 */
	public void insert(T entity);

	/**
	 * 删除对象
	 * @author yanziqi
	 * @param query 要删除的实体对象，不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午3:20:01
	 */
	public int delete(T query);

	/**
	 * 根据Id删除对象
	 * @author yanziqi
	 * @param id 要删除的ID，不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午3:20:27
	 */
	public int deleteById(Integer id);

	/**
	 * 删除所有
	 * @author yanziqi
	 * @return 受影响结果数
	 * @date 2014年12月9日下午3:21:04
	 */
	public int deleteAll();

	/**
	 * 更新对象，对象必须设置ID
	 * @author yanziqi 
	 * @param entity 实体的Id不能为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午3:21:21
	 */
	public int updateById(T entity);

	/**
	 * 更新对象中已设置的字段，未设置的字段不更新
	 * @author yanziqi
	 * @param entity 要更新的实体对象，不能为null，切ID必须不为null
	 * @return 受影响结果数
	 * @date 2014年12月9日下午3:23:32
	 */
	public int updateByIdSelective(T entity);

	/**
	 * 根据id，批量删除记录，如果传入的列表为null或为空列表则直接返回
	 * @author yanziqi
	 * @param idList 批量删除ID列表
	 * @date 2014年12月9日下午3:24:26
	 */
	public void deleteByIdInBatch(List<Integer> idList);

}
