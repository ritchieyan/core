package com.wyrz.core.checker;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 列表校验器
 * 
 * @author Ritchieyan
 * @date 2014年12月17日上午10:38:20
 */
public interface ListChecker<S, T> extends Checker<S, T> {
	/**
	 * 校验对象列表
	 * 
	 * @author Ritchieyan
	 * @param sources
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:43:18
	 */
	public List<T> check(List<S> sources) throws ICoreException;

	/**
	 * 校验对象列表
	 * 
	 * @author Ritchieyan
	 * @param sources 待检源数据列表
	 * @param fullMode 是/否使用全模式
	 * @return 检测结果列表
	 * @throws ICoreException
	 * @date 2014年12月17日上午10:43:30
	 */
	public List<T> check(List<S> sources, boolean fullMode) throws ICoreException;
}
