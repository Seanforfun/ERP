package ca.mcmaster.erp.invoice.store.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;
import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.invoice.store.model.StoreQueryModel;
import ca.mcmaster.erp.invoice.store.service.ebi.StoreEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

@SuppressWarnings("serial")
public class StoreAction extends BaseAction {
	public StoreModel sm = new StoreModel();
	public StoreQueryModel sqm = new StoreQueryModel(); 
	@Resource(name="storeEbi")
	private StoreEbi storeEbi;
	@Resource(name="empEbi")
	private EmpEbi empEbi;

	public String list(){
		super.setDataTotal(storeEbi.getCount(sqm));
		List<StoreModel> storeList = storeEbi.getAll(sqm, maxPageNum, pageCount);
		super.put("storeList", storeList);
		return LIST;
	}

	public String input(){
		if(sm.getUuid() != null){
			sm = storeEbi.get(sm.getUuid());
		}
		List<EmpModel>  empList = empEbi.getByDept(getLogin().getDm().getUuid());
		put("empList", empList);
		return INPUT;
	}

	public String save(){
		if(sm.getUuid() == null){
			storeEbi.save(sm);
		}else{
			storeEbi.update(sm);
		}
		return TO_LIST;
	}

	public String delete(){
		storeEbi.delete(sm);
		return TO_LIST;
	}
}