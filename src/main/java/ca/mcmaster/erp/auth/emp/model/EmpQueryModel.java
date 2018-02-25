package ca.mcmaster.erp.auth.emp.model;

import ca.mcmaster.erp.utils.base.BaseQueryModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

public class EmpQueryModel extends EmpModel implements BaseQueryModel{
	private Long birthdayMax;
	private String birthdayMaxView;
	public String getBirthdayMaxView() {
		return birthdayMaxView;
	}

	public Long getBirthdayMax() {
		return birthdayMax;
	}

	public void setBirthdayMax(Long birthdayMax) {
		this.birthdayMax = birthdayMax;
		if(birthdayMax != null)
			this.birthdayMaxView = FormatUtils.formatDate(birthdayMax) ;
	}
}