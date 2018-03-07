package ca.mcmaster.erp.invoice.operdetail.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.operdetail.model.OperDetailModel;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailQueryModel;
import ca.mcmaster.erp.invoice.operdetail.service.ebi.OperDetailEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

@SuppressWarnings("serial")
public class OperDetailAction extends BaseAction {
	public OperDetailModel om = new OperDetailModel();
	public OperDetailQueryModel oqm = new OperDetailQueryModel(); 
	@Resource(name="operDetailEbi")
	private OperDetailEbi operDetailEbi;

	public String list(){
		super.setDataTotal(operDetailEbi.getCount(oqm));
		List<OperDetailModel> operDetailList = operDetailEbi.getAll(oqm, pageNum, pageCount);
		super.put("operDetailList", operDetailList);
		return LIST;
	}

	public String input(){
		if(om.getUuid() != null){
			om = operDetailEbi.get(om.getUuid());
		}
		return INPUT;
	}

	public String save(){
		if(om.getUuid() == null){
			operDetailEbi.save(om);
		}else{
			operDetailEbi.update(om);
		}
		return TO_LIST;
	}

	public String delete(){
		operDetailEbi.delete(om);
		return TO_LIST;
	}
}