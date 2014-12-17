package com.wyrz.core.filler;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 列表填充器模板类
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:53:38
 */
public abstract class ListFillerTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListFiller<S, T> {

	@Override
	public List<T> fill(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> fill(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}

	@Override
	public T call(S source) throws ICoreException {
		return this.fill(source);
	}
}
