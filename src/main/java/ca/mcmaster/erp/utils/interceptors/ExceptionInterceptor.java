package ca.mcmaster.erp.utils.interceptors;

import ca.mcmaster.erp.utils.exceptions.AppException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 6, 2018 12:28:24 PM
 */
@SuppressWarnings("serial")
public class ExceptionInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		try {
			return invocation.invoke();
		} catch (AppException e) {
			ActionSupport as = (ActionSupport) invocation.getAction();
			as.addActionError(e.getMessage());
			return "error";
		}
	}

}
