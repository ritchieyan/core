package com.wyrz.core.dao.demain;

import java.io.Serializable;
import java.math.BigInteger;

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
	public BigInteger getId();

	/**
	 * 设置主键标识
	 * 
	 * @author yanziqi
	 * @param id
	 * @date 2014年12月9日下午2:16:17
	 */
	public void setId(BigInteger id);

}
