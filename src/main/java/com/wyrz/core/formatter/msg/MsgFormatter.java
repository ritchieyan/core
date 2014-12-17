package com.wyrz.core.formatter.msg;

import java.util.List;

import com.wyrz.core.exception.ICoreException;
import com.wyrz.core.formatter.Formatter;

/**
 * 消息字符串格式化工具接口，该接口支持将任意给定数据列表格式化成某种格式的字符串，
 * 这通常应用于需要在业务以一种标准格式来显示某类信息时用到
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:05:20
 */
public interface MsgFormatter<S> extends Formatter<S, String> {
	/**
	 * 格式化列表数据为字符串
	 * @Author Ritchieyan
	 * @param sources
	 * @return
	 * @throws ICoreException
	 * @Date 2014年12月17日下午12:05:20
	 */
	public String format(List<S> sources) throws ICoreException;
}
