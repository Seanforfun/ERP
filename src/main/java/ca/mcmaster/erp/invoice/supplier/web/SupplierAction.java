package ca.mcmaster.erp.invoice.supplier.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:05:27 PM
 */
@SuppressWarnings("serial")
public class SupplierAction extends BaseAction {
	public SupplierModel sm = new SupplierModel();
	@Resource(name="supplierEbi")
	private SupplierEbi supplierEbi;
	
	public String list(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList", supplierList);
		return LIST;
	}
	
	public String input(){
		if(sm.getUuid() != null){
			sm = supplierEbi.get(sm.getUuid());
		}
		return INPUT;
	}
	
	public String save(){
		if(sm.getUuid() != null){
			supplierEbi.update(sm);
		}else{
			supplierEbi.save(sm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		supplierEbi.delete(sm);
		return TO_LIST;
	}
}
