package com.wyrz.core.checker;

import com.wyrz.core.exception.ICoreException;

/**
 * 检验器接口
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:35:25
 */
public interface Checker<S, T> {
	/**
	 * 对给定源数据对象进行某种规则的检测，通常本接口的返回值是个布尔值对象
	 * 
	 * @author Ritchieyan
	 * @param source
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:35:45
	 */
	public T check(S source) throws ICoreException;

}
