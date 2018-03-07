package ca.mcmaster.erp.invoice.storedetail.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.invoice.storedetail.service.ebi.StoreDetailEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

@SuppressWarnings("serial")
public class StoreDetailAction extends BaseAction {
	public StoreDetailModel sm = new StoreDetailModel();
	public StoreDetailQueryModel sqm = new StoreDetailQueryModel(); 
	@Resource(name="storeDetailEbi")
	private StoreDetailEbi storeDetailEbi;

	public String list(){
		super.setDataTotal(storeDetailEbi.getCount(sqm));
		List<StoreDetailModel> storeDetailList = storeDetailEbi.getAll(sqm, pageNum, pageCount);
		super.put("storeDetailList", storeDetailList);
		return LIST;
	}

	public String input(){
		if(sm.getUuid() != null){
			sm = storeDetailEbi.get(sm.getUuid());
		}
		return INPUT;
	}

	public String save(){
		if(sm.getUuid() == null){
			storeDetailEbi.save(sm);
		}else{
			storeDetailEbi.update(sm);
		}
		return TO_LIST;
	}

	public String delete(){
		storeDetailEbi.delete(sm);
		return TO_LIST;
	}
}