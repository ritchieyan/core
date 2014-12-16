package com.wyrz.core.converter;

import com.wyrz.core.exception.ICoreException;

/**
 * 转换器接口
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:01:09
 */
public interface Converter<S, T> {
	public T convert(S source) throws ICoreException;
}
