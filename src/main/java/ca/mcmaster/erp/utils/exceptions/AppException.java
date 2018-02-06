package ca.mcmaster.erp.utils.exceptions;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 6, 2018 12:23:07 PM
 */
public class AppException extends RuntimeException{

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}
	
}
