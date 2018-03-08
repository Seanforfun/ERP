package ca.mcmaster.erp.invoice.storedetail.model;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.store.model.StoreModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 7, 2018 4:34:16 PM
 */
public class StoreDetailModel {
	private Long uuid;
	private Integer num;

	private StoreModel sm;
	private GoodsModel gm;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public StoreModel getSm() {
		return sm;
	}

	public void setSm(StoreModel sm) {
		this.sm = sm;
	}

	public GoodsModel getGm() {
		return gm;
	}

	public void setGm(GoodsModel gm) {
		this.gm = gm;
	}
}
