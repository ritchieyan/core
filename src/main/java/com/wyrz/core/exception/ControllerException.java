package com.wyrz.core.exception;

/**
 * 控制层异常信息
 * @author yanziqi
 * @date 2014年12月9日下午4:17:59
 */
public class ControllerException extends RuntimeException {

	/**
	 * @fields serialVersionUID 
	 */
	private static final long serialVersionUID = 4081863331832266720L;

	public ControllerException() {
		super();
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

}
