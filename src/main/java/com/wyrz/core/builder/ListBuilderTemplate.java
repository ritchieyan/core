package com.wyrz.core.builder;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 列表数据构建器模板 
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:34:33
 */
public abstract class ListBuilderTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListBuilder<S, T> {
	@Override
	public List<T> build(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> build(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}

	@Override
	public T call(S source) throws ICoreException {
		return this.build(source);
	}
}
