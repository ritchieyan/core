package com.wyrz.core.callback;

import com.wyrz.core.exception.ICoreException;

/**
 * 回调接口
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午8:39:59
 */
public interface Callback<S, T> {
	/**
	 * 回调入口点,此方法通过回调其它方法来完成功能
	 * 
	 * @author Ritchieyan
	 * @param source
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月16日下午8:40:17
	 */
	public T call(S source) throws ICoreException;
}
