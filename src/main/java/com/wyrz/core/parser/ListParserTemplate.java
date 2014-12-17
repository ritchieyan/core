package com.wyrz.core.parser;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.iterator.ListIteratorTemplate;

/**
 * 列表数据解析器模板类
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:57:32
 */
public abstract class ListParserTemplate<S, T> extends ListIteratorTemplate<S, T> implements ListParser<S, T> {
	@Override
	public T call(S source) throws ICoreException {
		return this.parser(source);
	}

	@Override
	public List<T> parser(List<S> sources) throws ICoreException {
		return this.iterator(sources);
	}

	@Override
	public List<T> parser(List<S> sources, boolean fullMode) throws ICoreException {
		return this.iterator(sources, fullMode);
	}
}
