package com.wyrz.core.builder;

import com.wyrz.core.exception.ICoreException;

/**
 * 构建器接口，主要应用于构建模式情景
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:32:47
 */
public interface Builder<S, T> {
	public T build(S source) throws ICoreException;
}
