package com.wyrz.core.checker;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 列表检验器模板
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:44:10
 */
public abstract class ListCheckerTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListChecker<S, T> {
	@Override
	public List<T> check(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> check(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}

	@Override
	public T call(S source) throws ICoreException {
		return this.check(source);
	}
}
