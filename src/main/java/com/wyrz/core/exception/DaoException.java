package com.wyrz.core.exception;

/**
 * Dao层异常信息
 * @author yanziqi
 * @date 2014年12月9日下午4:19:02
 */
public class DaoException extends RuntimeException {

	/**
	 * @fields serialVersionUID 
	 */
	private static final long serialVersionUID = 8350049272861703406L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
