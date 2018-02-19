package ca.mcmaster.erp.auth.menu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.menu.model.MenuQueryModel;
import ca.mcmaster.erp.auth.menu.service.ebi.MenuEbi;
import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.auth.role.service.ebi.RoleEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:07:09 PM
 */
@SuppressWarnings("serial")
public class MenuAction extends BaseAction {
	public MenuModel mm = new MenuModel();
	public MenuQueryModel mqm = new MenuQueryModel();
	@Resource(name="menuEbi")
	private MenuEbi menuEbi;
	@Resource(name="roleEbi")
	private RoleEbi roleEbi;
	public Long[] roleUuids;
	
	public String save(){
		if(mm.getUuid() == null){
			menuEbi.save(mm, roleUuids);
		}else{
			menuEbi.update(mm, roleUuids);
		}
		return TO_LIST;
	}
	
	public String delete(){
		menuEbi.delete(mm);
		return TO_LIST;
	}
	
	public String list(){
		List<MenuModel> parentList = menuEbi.getAllLevelOne();
		put("parentList", parentList);
		setDataTotal(menuEbi.getCount(mqm));
		List<MenuModel> menuList = menuEbi.getAll(mqm, pageNum, pageCount);
		put("menuList", menuList);
		return LIST;
	}
	
	public String input(){
		List<RoleModel> roleList = roleEbi.getAll();
		put("roleList", roleList);
		if(mm.getUuid() != null){
			mm = menuEbi.get(mm.getUuid());
			roleUuids = new Long[mm.getRoleModels().size()];
			int i = 0;
			for(RoleModel temp:mm.getRoleModels()){
				roleUuids[i] = temp.getUuid();
				i++;
			}
		}
		List<MenuModel> menuList = menuEbi.getAllLevelOne();
		put("menuList", menuList);
		return INPUT;
	}
	
	public void showMenu() throws IOException{
		HttpServletResponse response = super.getResponse();
		response.setContentType("text/heml;charset=utf-8");
		StringBuilder json = new StringBuilder();
		json.append("[");
		List<MenuModel> menuList = menuEbi.getAllLevelOneWithoutSystem();
		for(MenuModel temp : menuList){
			json.append("{\"text\": \"");
			json.append(temp.getName());
			json.append("\", \"hasChildren\":true, \"classes\":\"folder\"},");
		}
		json.deleteCharAt(json.lastIndexOf(","));
		json.append("]");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.flush();
	}
}
