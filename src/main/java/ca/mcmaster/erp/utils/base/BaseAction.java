package ca.mcmaster.erp.utils.base;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 29, 2018 9:19:31 PM
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.erp.auth.emp.model.EmpModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction  extends ActionSupport{
	public static final String LIST = "list";
	public static final String TO_LIST = "toList";
	public static final String INPUT = "input";
	
	public Integer pageNum = 1;
	public Integer pageCount = 10;
	public Integer maxPageNum;
	public Integer dataTotal;
	
	public String getActionName(){
		//¶¯Ì¬
		//DepAction ->dep
		//EmpAction ->emp
		String actionName = this.getClass().getSimpleName();
		//DepAction ->Dep
		String temp = actionName.substring(0, actionName.length()-6);
		//Dep ->dep		OrderDetailAction   ->orderDetail  orderdetail
		return temp.substring(0,1).toLowerCase()+temp.substring(1);
	}
	
	protected void setDataTotal(int dataTotal){
		this.dataTotal = dataTotal ;
		maxPageNum = (dataTotal + pageCount -1) / pageCount;
	}
	
	protected void put(String name,Object obj){
		ActionContext.getContext().put(name,obj);
	}
	
	protected Object get(String name){
		return ActionContext.getContext().get(name);
	}
	
	protected void putSession(String name,Object obj){
		ActionContext.getContext().getSession().put(name,obj);
	}
	
	protected Object getSession(String name){
		return ActionContext.getContext().getSession().get(name);
	}
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	protected String getLogin(){
		return (String) getSession(EmpModel.LOGIN_EMP);
	}
}
