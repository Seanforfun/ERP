package ca.mcmaster.erp.auth.emp.service.ebo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;
import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.utils.base.BaseQueryModel;
import ca.mcmaster.erp.utils.exceptions.AppException;
import ca.mcmaster.erp.utils.format.MD5Utils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:07:59 PM
 */
public class EmpEbo implements EmpEbi{
	@Resource(name="empDao")
	private EmpDao empDao;
	public EmpModel login(String username, String password, String loginIp) {
		EmpModel tmpEmp = null;
		if(null != password){
			String md5Pwd = MD5Utils.md5(password);
			tmpEmp = empDao.getUserByUsernameAndPassword(username, md5Pwd);
			if (null != tmpEmp) {
				tmpEmp.setLastLoginTime(System.currentTimeMillis());
				tmpEmp.setLoginTimes(tmpEmp.getLoginTimes() + 1);
				tmpEmp.setLastLoginIp(loginIp);
			}
		}
		return tmpEmp;
	}
	public Integer getCount(BaseQueryModel bqm) {
		Integer count = empDao.getCount(bqm);
		return count;
	}
	
	@Deprecated
	public void save(EmpModel t) {
		if(null == t.getUsername() || t.getUsername().trim().length() == 0){
			throw new AppException("INFO_EMP_USERNAME_IS_EMPTY");
		}
		t.setPassword(MD5Utils.md5(t.getPassword()));
		t.setLastLoginTime(System.currentTimeMillis());
		t.setLastLoginIp("-");
		t.setLoginTimes(0);
		empDao.save(t);
	}
	public void delete(EmpModel t) {
		empDao.delete(t);
	}
	
	@Deprecated
	public void update(EmpModel t) {
		EmpModel temp = empDao.get(t.getUuid());
		temp.setAddress(t.getAddress());
		temp.setGender(t.getGender());
		temp.setEmail(t.getEmail());
		temp.setTele(t.getTele());;
		temp.setDm(t.getDm());
		temp.setName(t.getName());
		empDao.update(temp);
	}
	public EmpModel get(Serializable uuid) {
		EmpModel temp = empDao.get(uuid);
		return temp;
	}
	public List<EmpModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<EmpModel> empList = empDao.getAll(bqm, pageNum, pageCount);
		return empList;
	}
	public List<EmpModel> getAll(BaseQueryModel bqm) {
		List<EmpModel> empList = empDao.getAll(bqm);
		return empList;
	}
	public List<EmpModel> getAll() {
		List<EmpModel> empList = empDao.getAll();
		return empList;
	}
	public Boolean changePwd(String loginName, String password, String newPassword) {
		String md5Pwd = MD5Utils.md5(password);
		String md5NewPwd = MD5Utils.md5(newPassword);
		return empDao.changePwdByNameAndPassword(loginName, md5Pwd, md5NewPwd);
	}
	public void save(EmpModel em, Long[] roleUuids) {
		if(null == em.getUsername() ||em.getUsername().trim().length() == 0){
			throw new AppException("INFO_EMP_USERNAME_IS_EMPTY");
		}
		
		Set<RoleModel> roleModels = new HashSet<RoleModel>();
		for (Long uuid:roleUuids) {
			RoleModel temp = new RoleModel();
			temp.setUuid(uuid);
			roleModels.add(temp);
		}
		em.setRoleModels(roleModels);
		em.setPassword(MD5Utils.md5(em.getPassword()));
		em.setLastLoginTime(System.currentTimeMillis());
		em.setLastLoginIp("-");
		em.setLoginTimes(0);
		empDao.save(em);
	}
	
	public void update(EmpModel em, Long[] roleUuids) {
		Set<RoleModel> roleModels = new HashSet<RoleModel>();
		for(Long uuid : roleUuids){
			RoleModel rm = new RoleModel();
			rm.setUuid(uuid);
			roleModels.add(rm);
		}
		EmpModel temp = empDao.get(em.getUuid());
		temp.setRoleModels(roleModels);
		temp.setAddress(em.getAddress());
		temp.setGender(em.getGender());
		temp.setEmail(em.getEmail());
		temp.setTele(em.getTele());;
		temp.setDm(em.getDm());
		temp.setName(em.getName());
		empDao.update(temp);
	}
	
	public List<EmpModel> getByDept(Integer uuid) {
		return empDao.getAllByDeptUuid(uuid);
	}
}
