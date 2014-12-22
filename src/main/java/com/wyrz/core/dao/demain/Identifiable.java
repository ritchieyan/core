package com.wyrz.core.dao.demain;

import java.io.Serializable;

/**
 * 主键标识
 * 
 * @author yanziqi
 * @date 2014年12月9日下午2:12:46
 */
public interface Identifiable extends Serializable {

	/**
	 * 获取主键标识
	 * 
	 * @author yanziqi
	 * @return
	 * @date 2014年12月9日下午2:16:06
	 */
	public Integer getId();

	/**
	 * 设置主键标识
	 * 
	 * @author yanziqi
	 * @param id
	 * @date 2014年12月9日下午2:16:17
	 */
	public void setId(Integer id);

}
