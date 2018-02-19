package ca.mcmaster.erp.auth.role.service.ebo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.role.dao.dao.RoleDao;
import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.auth.role.service.ebi.RoleEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:32:52 PM
 */
public class RoleEbo implements RoleEbi {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Deprecated
	public void save(RoleModel t) {
		roleDao.save(t);
	}

	public void delete(RoleModel t) {
		roleDao.delete(t);
	}

	@Deprecated
	public void update(RoleModel t) {
		roleDao.update(t);
	}

	public RoleModel get(Serializable uuid) {
		RoleModel temp = roleDao.get(uuid);
		return temp;
	}

	public List<RoleModel> getAll() {
		List<RoleModel> roleList = roleDao.getAll();
		return roleList;
	}

	public List<RoleModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<RoleModel> roleList = roleDao.getAll(bqm, pageNum, pageCount);
		return roleList;
	}

	public List<RoleModel> getAll(BaseQueryModel bqm) {
		List<RoleModel> roleList = roleDao.getAll(bqm);
		return roleList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = roleDao.getCount(bqm);
		return count;
	}

	public void save(RoleModel rm, Long[] resourcesUuid) {
		Set<ResourcesModel> resourcesModels = new HashSet<ResourcesModel>();
		for(Long uuid:resourcesUuid){
			ResourcesModel temp = new ResourcesModel();
			temp.setUuid(uuid);
			resourcesModels.add(temp);
		}
		rm.setResourcesModels(resourcesModels);
		roleDao.save(rm);
	}

	public void update(RoleModel rm, Long[] resourcesUuid) {
		RoleModel temp = roleDao.get(rm.getUuid());
		Set<ResourcesModel> resourcesModels= new HashSet<ResourcesModel>();
		for(Long uuid:resourcesUuid){
			ResourcesModel temp1 = new ResourcesModel();
			temp1.setUuid(uuid);
			resourcesModels.add(temp1);
		}
		temp.setResourcesModels(resourcesModels);
		temp.setName(rm.getName());
		temp.setCode(rm.getCode());
		roleDao.update(temp);
	}

	public void save(RoleModel rm, Long[] resUuids, Long[] menuUuids) {
		Set<ResourcesModel> resourcesModels = new HashSet<ResourcesModel>();
		for(Long uuid:resUuids){
			ResourcesModel temp = new ResourcesModel();
			temp.setUuid(uuid);
			resourcesModels.add(temp);
		}
		Set<MenuModel> menuModels = new HashSet<MenuModel>();
		for(Long uuid:menuUuids){
			MenuModel temp = new MenuModel();
			temp.setUuid(uuid);
			menuModels.add(temp);
		}
		rm.setMenuModels(menuModels);
		rm.setResourcesModels(resourcesModels);
		roleDao.save(rm);
	}

	public void update(RoleModel rm, Long[] resUuids, Long[] menuUuids) {
		RoleModel temp = roleDao.get(rm.getUuid());
		Set<ResourcesModel> resourcesModels= new HashSet<ResourcesModel>();
		for(Long uuid:resUuids){
			ResourcesModel temp1 = new ResourcesModel();
			temp1.setUuid(uuid);
			resourcesModels.add(temp1);
		}
		Set<MenuModel> menuModels= new HashSet<MenuModel>();
		for(Long uuid:menuUuids){
			System.out.println("==========" + uuid);
			MenuModel temp1 = new MenuModel();
			temp1.setUuid(uuid);
			menuModels.add(temp1);
		}
		temp.setMenuModels(menuModels);
		temp.setResourcesModels(resourcesModels);
		temp.setName(rm.getName());
		temp.setCode(rm.getCode());
		roleDao.update(temp);
	}
}
