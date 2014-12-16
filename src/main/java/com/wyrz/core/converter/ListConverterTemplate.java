package com.wyrz.core.converter;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 集合列表对象转换器，将列表对象转换成另一类型对象
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:03:34
 */
public abstract class ListConverterTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListConverter<S, T> {

	@Override
	public List<T> convert(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> convert(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}

	@Override
	public T call(S source) throws ICoreException {
		return this.convert(source);
	}
}
