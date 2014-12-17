package com.wyrz.core.filler;

import com.wyrz.core.exception.ICoreException;

/**
 * 填充器接口
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:52:21
 */
public interface Filler<S, T> {
	public T fill(S source) throws ICoreException;
}
