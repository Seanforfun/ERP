package ca.mcmaster.erp.utils.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.res.service.ebi.ResourcesEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 7:31:34 PM
 */
public class AllResLoadListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		ResourcesEbi resourcesEbi = (ResourcesEbi) ctx.getBean("resourcesEbi");
		List<ResourcesModel> resourcesModels = resourcesEbi.getAll();//resourcesEbi.getAll();
		StringBuilder sb = new StringBuilder();
		for(ResourcesModel rm : resourcesModels){
			sb.append(rm.getUrl());
			sb.append(",");
		}
		sc.setAttribute("resList", sb.toString());
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
