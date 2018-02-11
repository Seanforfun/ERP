package ca.mcmaster.erp.auth.res.service.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 10:16:17 PM
 */
@Transactional
public interface ResourcesEbi extends BaseEbi<ResourcesModel> {
	/**
	 * @Description: Get the resources list of selected emp
	 * @param uuid
	 * @return
	 */
	public List<ResourcesModel> getAllByEmp(Integer uuid);
}
