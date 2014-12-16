package com.wyrz.core.converter;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表转换器
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:01:26
 */
public interface ListConverter<S, T> extends Converter<S, T> {
	/**
	 * 转换集合列表包含的对象
	 * 
	 * @author Ritchieyan
	 * @param sources 集合对象
	 * @return 转换失败将返回null
	 * @throws ICoreException
	 * @date 2014年12月16日下午10:01:57
	 */
	public List<T> convert(List<S> sources) throws ICoreException;

	/**
	 * 转换集合列表包含的对象
	 * 
	 * @author Ritchieyan
	 * @param sources 集合对象
	 * @param fullMode 是/否使用全模式
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月16日下午10:02:44
	 */
	public List<T> convert(List<S> sources, boolean fullMode) throws ICoreException;
}
