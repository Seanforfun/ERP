package ca.mcmaster.erp.invoice.bill.model;

import ca.mcmaster.erp.utils.base.BaseQueryModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

public class BillQueryModel implements BaseQueryModel{
	private Integer type;
	private Long supplierUuid;
	private Long start;
	private Long end;
	
	private String startView;
	private String endView;
	public String getStartView() {
		return startView;
	}
	public String getEndView() {
		return endView;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getSupplierUuid() {
		return supplierUuid;
	}
	public void setSupplierUuid(Long supplierUuid) {
		this.supplierUuid = supplierUuid;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.startView = FormatUtils.formatDateTime(start);
		this.start = start;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.endView = FormatUtils.formatDate(end);
		this.end = end;
	}
}