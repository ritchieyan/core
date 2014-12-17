package com.wyrz.core.parser;

import com.wyrz.core.exception.ICoreException;

/**
 * 解析器接口
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:58:12
 */
public interface Parser<S, T> {
	public T parser(S source) throws ICoreException;
}
