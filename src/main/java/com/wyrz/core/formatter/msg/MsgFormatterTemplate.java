package com.wyrz.core.formatter.msg;

import java.util.List;

import com.wyrz.core.exception.ICoreException;

/**
 * 消息字符串格式化模板类
 * 
 * @author Ritchieyan
 * @date 2014年12月17日下午12:06:08
 */
public abstract class MsgFormatterTemplate<S> implements MsgFormatter<S> {
	@Override
	public String format(List<S> sources) throws ICoreException {
		if (sources == null || sources.isEmpty()) {
			return "";
		}
		StringBuilder rawStr = new StringBuilder();
		rawStr.append(formatHead());
		for (S source : sources) {
			rawStr.append(format(source));
		}
		return formatRawStr(rawStr.toString());
	}

	/**
	 * 格式化字符串之前做一些初始化工作，例如添加一行标题
	 * @author Ritchieyan
	 * @return 返回要添加的字符串
	 * @throws ICoreException
	 * @date 2014年12月17日下午12:06:08
	 */
	protected String formatHead() throws ICoreException {
		return "";
	}

	/**
	 * 处理组织好的数据，如去掉末尾可能的一些多余分隔符号或作进一步处理
	 * @Author Ritchieyan
	 * @param rawStr 初步组织好的字符串
	 * @return 处理后的字符串
	 * @throws ICoreException
	 * @Date 2014年12月17日下午12:06:08
	 */
	protected String formatRawStr(String rawStr) throws ICoreException {
		return rawStr;
	}
}
