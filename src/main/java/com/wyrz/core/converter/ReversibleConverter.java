package com.wyrz.core.converter;

import com.wyrz.core.exception.ICoreException;

/**
 * 可送转换接口，该接口扩展了转换接口，并增加了逆向转换接口方法，对于所有需要进行双向转换时可以使用此接口来实现
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午10:06:57
 */
public interface ReversibleConverter<S, T> extends Converter<S, T> {
	/**
	 * 反向转换接口
	 * 
	 * @author Ritchieyan
	 * @param target
	 * @return
	 * @throws ICoreException
	 * @date 2014年12月16日下午10:07:08
	 */
	public S reconvert(T target) throws ICoreException;
}
