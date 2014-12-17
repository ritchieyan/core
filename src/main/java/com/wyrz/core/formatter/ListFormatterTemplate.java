package com.wyrz.core.formatter;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 列表格式化模板实现
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:04:48
 */
public abstract class ListFormatterTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListFormatter<S, T> {

	@Override
	public T call(S source) throws ICoreException {
		return this.format(source);
	}

	@Override
	public List<T> format(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> format(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}

}
