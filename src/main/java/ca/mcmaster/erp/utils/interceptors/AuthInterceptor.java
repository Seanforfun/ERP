package ca.mcmaster.erp.utils.interceptors;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.res.service.ebi.ResourcesEbi;
import ca.mcmaster.erp.utils.exceptions.AppException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 10, 2018 10:15:04 PM
 */
@SuppressWarnings("serial")
public class AuthInterceptor extends AbstractInterceptor {
	private ResourcesEbi resourcesEbi;
	
	public void setResourcesEbi(ResourcesEbi resourcesEbi) {
		this.resourcesEbi = resourcesEbi;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String resource = actionName + "." + methodName;
//		if("ca.mcmaster.erp.auth.emp.web.EmpAction.login".equals(resource)){
//			return invocation.invoke();
//		}
		String resList = (String) ServletActionContext.getServletContext().getAttribute("resList");
		if(!resList.contains(resource)){
			invocation.invoke();
		}
		EmpModel em =  (EmpModel) invocation.getInvocationContext().getSession().get(EmpModel.LOGIN_EMP);
		if(null == em){
			return "nologin";
		}
		
		List<ResourcesModel> resourcesModels = resourcesEbi.getAllByEmp(em.getUuid());
		for(ResourcesModel rm : resourcesModels){
			if(rm.getUrl().equals(resource)){
				return invocation.invoke();
			}
		}
		throw new AppException("Please don't euecute unauthorized actions!");
	}
	
}
