package ca.mcmaster.erp.auth.menu.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:07:53 PM
 */
@Transactional
public interface MenuEbi extends BaseEbi<MenuModel> {

}
