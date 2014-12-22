package com.wyrz.core.mapper.provider;

import java.util.Map;

/**
 * Sql语句基础支持器
 * @author Ritchieyan
 * @date 2014年12月18日下午6:32:49
 */
public interface BaseMapperProvider {

	/**
	 * 查询结果
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月18日下午7:03:43
	 */
	public String getColumnList();

	/**
	 * 查询条件
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月18日下午7:03:53
	 */
	public String getWhereClause(Map<String, Object> params);

	/**
	 * 排序条件
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月18日下午7:04:06
	 */
	public String getOrderByClause(Map<String, Object> params);

	/**
	 * 分组条件
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月18日下午7:04:26
	 */
	public String getGroupByClause(Map<String, Object> params);

	/**
	 * 分页条件
	 * 
	 * @author Ritchieyan
	 * @param params
	 * @return
	 * @date 2014年12月19日上午11:45:13
	 */
	public String getLimitClause(Map<String, Object> params);

}
