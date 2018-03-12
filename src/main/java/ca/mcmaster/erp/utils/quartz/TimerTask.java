package ca.mcmaster.erp.utils.quartz;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 11, 2018 6:35:00 PM
 */
public class TimerTask {
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
	/*update
	tbl_goods g
	set
		useNum = 
	(
	select
		count(uuid)
	from
		tbl_orderdetail
	where
		goodsuuid = g.uuid
	)*/
	public void goodUseNumUpdate(){
		goodsEbi.goodUseNumUpdate();
	}
}
