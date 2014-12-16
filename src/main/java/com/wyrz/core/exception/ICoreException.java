package com.wyrz.core.exception;

/**
 * 核心部分异常信息处理
 * 
 * @author Ritchieyan
 * @date 2014年12月16日下午8:39:37
 */
public class ICoreException extends RuntimeException {

	private static final long serialVersionUID = -4485426320617022113L;

	public ICoreException() {
		super();
	}

	public ICoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public ICoreException(Object object, Throwable cause) {
		super(object.getClass().getName(), cause);
	}

	public ICoreException(Object object, String message, Throwable cause) {
		super(object.getClass().getName() + ":" + message, cause);
	}

	public ICoreException(String message) {
		super(message);
	}

	public ICoreException(Throwable cause) {
		super(cause);
	}

}
