package ca.mcmaster.erp.auth.emp.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;
import ca.mcmaster.erp.utils.format.MD5Utils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:07:59 PM
 */
public class EmpEbo implements EmpEbi{
	@Resource(name="empDao")
	private EmpDao empDao;
	public EmpModel login(String username, String password) {
		EmpModel tmpEmp = null;
		if(null != password){
			String md5Pwd = MD5Utils.md5(password);
			tmpEmp = empDao.getUserByUsernameAndPassword(username, md5Pwd);
		}
		return tmpEmp;
	}
	public Integer getCount(BaseQueryModel bqm) {
		Integer count = empDao.getCount(bqm);
		return count;
	}
	public void save(EmpModel t) {
		t.setPassword(MD5Utils.md5(t.getPassword()));
		empDao.save(t);
	}
	public void delete(EmpModel t) {
		empDao.delete(t);
	}
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
}
