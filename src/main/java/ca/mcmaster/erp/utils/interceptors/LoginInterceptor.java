package ca.mcmaster.erp.utils.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 7:40:02 PM
 */
@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String method = invocation.getProxy().getMethod();
		String actionName = invocation.getAction().getClass().getName();
		String compare = actionName + "." + method;
		if("ca.mcmaster.erp.auth.emp.web.EmpAction.login".equals(compare)){
			return invocation.invoke();
		}else{
			Map<String, Object> session = ActionContext.getContext().getSession();
			if(session.containsKey("login_emp")){
				return invocation.invoke();
			}else{
				return "nologin";
			}
		}
	}
}
