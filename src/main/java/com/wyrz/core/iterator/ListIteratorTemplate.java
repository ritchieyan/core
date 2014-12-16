package com.wyrz.core.iterator;

import java.util.ArrayList;
import java.util.List;

import com.wyrz.core.callback.Callback;
import com.wyrz.core.exception.ICoreException;

/**
 * 数据列表迭代处理模板实现类
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:00:20
 */
public abstract class ListIteratorTemplate<S, T> implements ListIterator<S, T>, Callback<S, T> {

	@Override
	public List<T> iterator(List<S> sources) throws ICoreException {
		return this.iterator(sources, false);
	}

	@Override
	public List<T> iterator(List<S> sources, boolean fullMode) throws ICoreException {
		if (sources == null || sources.isEmpty()) {
			return null;
		}
		List<T> targets = new ArrayList<T>();
		for (S source : sources) {
			if (source == null) {
				if (fullMode) {
					targets.add(null);
				}
				continue;
			}
			T target = this.call(source);
			if (target == null && fullMode) {
				targets.add(target);
				continue;
			}
			if (target != null) {
				targets.add(target);
			}
		}
		return targets;
	}

}
