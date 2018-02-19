package ca.mcmaster.erp.auth.menu.service.ebi;

import java.util.List;
import java.util.logging.Level;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:07:53 PM
 */
@Transactional
public interface MenuEbi extends BaseEbi<MenuModel> {
	/**
	 * @Description: Get all level one menu
	 * @return
	 */
	public List<MenuModel> getAllLevelOne();

	/**
	 * @Description: Save menu with role inforamtion.
	 * @param mm
	 * @param roleUuids
	 */
	public void save(MenuModel mm, Long[] roleUuids);

	/**
	 * @Description: Save menu with role inforamtion.
	 * @param mm
	 * @param roleUuids
	 */
	public void update(MenuModel mm, Long[] roleUuids);

	/**
	 * @Description: Get all level one menu without geting the system menu
	 * @return
	 */
	public List<MenuModel> getAllLevelOneWithoutSystem();

	/**
	 * @param loginUuid 
	 * @Description: Get the menu list of current employee.
	 * @return
	 */
	public List<MenuModel> getAllLevelOneByEmp(Integer loginUuid);

	/**
	 * @Description: Get all level2 menu according to level1 uuid and empUuid
	 * @param loginUuid
	 * @param parentUuid
	 * @return
	 */
	public List<MenuModel> getByEmpAndPUuid(Integer loginUuid,
			Long parentUuid);
}
