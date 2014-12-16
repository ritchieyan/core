package com.wyrz.core.converter;

import java.util.Map;

import com.wyrz.core.exception.ICoreException;

/**
 * 将给定列表结合按指定映射关系转换成Map的值列表集合
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:04:13
 */
public interface MapConverter extends ListConverter<String, String>, ReversibleConverter<String, String> {
	public void setConverter(Map<String, String> converter);

	public Map<String, String> getConverter();

	/**
	 * 作为key值转换成value值
	 */
	@Override
	public String convert(String key) throws ICoreException;

	/**
	 * 作为value值转换成key值
	 */
	@Override
	public String reconvert(String value) throws ICoreException;

	/**
	 * 转换方向：true:key==>value/false:value==>key
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月16日下午10:05:58
	 */
	public boolean isForwardConverter();

	/**
	 * 设置转换方向：true:key==>value/false:value==>key
	 * 
	 * @author Ritchieyan
	 * @param isForward 转换方向：true:key==>value/false:value==>key，默认是正向转换
	 * @date 2014年12月16日下午10:06:13
	 */
	public void setForwardConverter(boolean isForward);

	/**
	 * 判定Map是否存在元素
	 * 
	 * @author Ritchieyan
	 * @return
	 * @date 2014年12月16日下午10:06:40
	 */
	public boolean isEmpty();
}
