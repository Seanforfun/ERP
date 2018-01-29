package ca.mcmaster.erp.auth.dept.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:34:37 PM
 */
@Transactional
public interface DeptEbi extends BaseEbi<DeptModel> {

}
