package ca.mcmaster.erp.auth.role.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:32:16 PM
 */
@Transactional
public interface RoleEbi extends BaseEbi<RoleModel>{
	/**
	 * @Description: Save role with defined resourcesModel
	 * @param rm
	 * @param resourcesUuid
	 */
	void save(RoleModel rm, Long[] resourcesUuid);
	
	/**
	 * @Description: Update role with defined resourcesModels
	 * @param rm
	 * @param resourcesUuid
	 */
	void update(RoleModel rm, Long[] resourcesUuid);

	/**
	 * @Description: Save role with defined resourcesModel and menuModel
	 * @param rm
	 * @param resUuids
	 * @param menuUuids
	 */
	void save(RoleModel rm, Long[] resUuids, Long[] menuUuids);

	/**
	 * @Description: Update role with defined resourcesModel and menuModel
	 * @param rm
	 * @param resUuids
	 * @param menuUuids
	 */
	void update(RoleModel rm, Long[] resUuids, Long[] menuUuids);
}
