package ca.mcmaster.erp.invoice.order.service.ebo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.goods.dao.dao.GoodsDao;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.operdetail.dao.dao.OperDetailDao;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailModel;
import ca.mcmaster.erp.invoice.order.dao.dao.OrderDao;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.invoice.order.service.ebi.OrderEbi;
import ca.mcmaster.erp.invoice.orderdetail.dao.dao.OrderDetailDao;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.invoice.storedetail.dao.dao.StoreDetailDao;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.utils.base.BaseQueryModel;
import ca.mcmaster.erp.utils.exceptions.AppException;
import ca.mcmaster.erp.utils.num.NumUtil;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:08:32 PM
 */
@Transactional
public class OrderEbo implements OrderEbi {
	@Resource(name="orderDao")
	private OrderDao orderDao;
	@Resource(name="orderDetailDao")
	private OrderDetailDao orderDetailDao;
	@Resource(name="storeDetailDao")
	private StoreDetailDao storeDetailDao;
	@Resource(name = "operDetailDao")
	private OperDetailDao operDetailDao;
	public void save(OrderModel t) {
		orderDao.save(t);
	}

	public void delete(OrderModel t) {
		orderDao.delete(t);
	}

	public void update(OrderModel t) {
		orderDao.update(t);
	}

	public OrderModel get(Serializable uuid) {
		return orderDao.get(uuid);
	}

	public List<OrderModel> getAll() {
		return orderDao.getAll();
	}

	public List<OrderModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return orderDao.getAll(bqm, pageNum, pageCount);
	}

	public List<OrderModel> getAll(BaseQueryModel bqm) {
		return orderDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return orderDao.getCount(bqm);
	}

	public void saveBuyOrder(OrderModel om, Long[] goodsUuids, Integer[] nums,
			Double[] prices, EmpModel currentUser) {
		om.setCreateTime(System.currentTimeMillis());
		om.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		om.setType(OrderModel.ORDER_TYPE_OF_BUY_NO_CHECK);
		om.setCreator(currentUser);
		Set<OrderDetailModel> odms = new HashSet<OrderDetailModel>();
		Integer totaINum = new Integer(0);
		Double totalPrice = new Double(0); 
		for (int i = 0; i < goodsUuids.length; i++) {
			OrderDetailModel tempOdm = new OrderDetailModel();
			tempOdm.setOm(om);
			tempOdm.setNum(nums[i]);
			tempOdm.setPrice(prices[i]);
			tempOdm.setSurplus(nums[i]);
			GoodsModel tempGm = new GoodsModel();
			tempGm.setUuid(goodsUuids[i]);
			tempOdm.setGm(tempGm);
			odms.add(tempOdm);
			totaINum += nums[i];
			totalPrice += nums[i] * prices[i];
		}
		om.setOdms(odms);
		om.setTotalNum(totaINum);
		om.setTotalPrice(totalPrice);
		om.setOrderNum(NumUtil.generateOrdeNum());
		orderDao.save(om);
	}

	public List<OrderModel> getAllBuy(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount) {
		oqm.setOrderType(OrderModel.ORDER_ORDERTYPE_OF_BUY);
		return orderDao.getAll(oqm, maxPageNum, pageCount);
	}

	private Integer[] buyCheckOrderTypes = new Integer[]{
			OrderModel.ORDER_ORDERTYPE_OF_BUY, 
			OrderModel.ORDER_ORDERTYPE_OF_RETURN_BUY
	};
	
	public int getCountBuyCheck(OrderQueryModel oqm) {
		return orderDao.getCountOrderTypes(oqm, buyCheckOrderTypes);
	}

	public List<OrderModel> getAllBuyCheck(OrderQueryModel oqm,
			Integer maxPageNum, Integer pageCount) {
		return orderDao.getAllOrderTypes(oqm, maxPageNum, pageCount, buyCheckOrderTypes);
	}

	public void buyCheckPass(Long uuid, EmpModel checker) {
		OrderModel temp = orderDao.get(uuid);
		if(!temp.getType().equals(OrderModel.ORDER_TYPE_OF_BUY_NO_CHECK)){
			throw new AppException("请不要进行非法操作！");
		}
		temp.setType(OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS);
		temp.setCheckTime(System.currentTimeMillis());
		temp.setChecker(checker);
		orderDao.update(temp);
	}

	public void buyCheckReject(Long uuid, EmpModel login) {
		OrderModel temp = orderDao.get(uuid);
		if(!temp.getType().equals(OrderModel.ORDER_TYPE_OF_BUY_NO_CHECK)){
			throw new AppException("请不要进行非法操作！");
		}
		temp.setType(OrderModel.ORDER_TYPE_OF_BUY_CHECK_REJECT);
		temp.setCheckTime(System.currentTimeMillis());
		temp.setChecker(login);
		orderDao.update(temp);
	}

	private Integer[] taskTypes = new Integer[]{OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS,
			OrderModel.ORDER_TYPE_OF_BUY_BUYING,
			OrderModel.ORDER_TYPE_OF_BUY_IN_STORE,
			OrderModel.ORDER_TYPE_OF_BUY_COMPLETE
			};
	public int getCountTask(OrderQueryModel oqm) {
		return orderDao.getCountTypes(oqm, taskTypes);
	}
	public List<OrderModel> getAllTask(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount) {
		return orderDao.getAllTypes(oqm, maxPageNum, pageCount, taskTypes);
	}

	public void assignTask(Long uuid, EmpModel completer) {
		OrderModel temp = orderDao.get(uuid);
		if(!temp.getType().equals(OrderModel.ORDER_TYPE_OF_BUY_CHECK_PASS)){
			throw new AppException("请不要进行非法操作！");
		}
		temp.setType(OrderModel.ORDER_TYPE_OF_BUY_BUYING);
		temp.setCompleter(completer);
		orderDao.update(temp);
	}

	public List<OrderModel> getAllTask(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount, EmpModel login) {
		oqm.setCompleter(login);
		return orderDao.getAll(oqm, maxPageNum, pageCount);
	}

	public Integer getCountBuyLogin(OrderQueryModel oqm, EmpModel empModel) {
		oqm.setCompleter(empModel);
		return orderDao.getCount(oqm);
	}

	public void endTask(Long uuid) {
		OrderModel temp = orderDao.get(uuid);
		if(!temp.getType().equals(OrderModel.ORDER_TYPE_OF_BUY_BUYING)){
			throw new AppException("请不要进行非法操作！");
		}
		temp.setType(OrderModel.ORDER_TYPE_OF_BUY_IN_STORE);
		orderDao.update(temp);
	}

	public Integer getCountInStore(OrderQueryModel oqm) {
		oqm.setType(OrderModel.ORDER_TYPE_OF_BUY_IN_STORE);
		return orderDao.getCount(oqm);
	}

	public List<OrderModel> getAllInStore(OrderQueryModel oqm,
			Integer maxPageNum, Integer pageCount) {
		oqm.setType(OrderModel.ORDER_TYPE_OF_BUY_IN_STORE);
		return orderDao.getAll(oqm, maxPageNum, pageCount);
	}

	public OrderDetailModel inGoods(Long storeUuid, Long odmUuid, Integer num, EmpModel login) {
		//1. Update the orderDetails
		OrderDetailModel tempOdm = orderDetailDao.get(odmUuid);	
		if(!tempOdm.getOm().getType().equals(OrderModel.ORDER_TYPE_OF_BUY_IN_STORE)){
			throw new AppException("请不要进行非法操作！");
		}
		if(tempOdm.getSurplus() < num){
			throw new AppException("入库数量应小于剩余数量！");
		}
		tempOdm.setSurplus(tempOdm.getSurplus() - num);
		orderDetailDao.update(tempOdm);
		
		//2.Update storeDetail
		//Check if the current goods had store detail before
		GoodsModel gm = new GoodsModel();
		gm.setUuid(tempOdm.getGm().getUuid());
		StoreModel sm = new StoreModel();
		sm.setUuid(storeUuid);
		StoreDetailModel tempSdm = storeDetailDao.getBySmAndGm(storeUuid, tempOdm.getGm().getUuid());
		if(null != tempSdm){
			tempSdm.setNum(tempSdm.getNum() + num);
			storeDetailDao.update(tempSdm);
		}else{
			tempSdm = new StoreDetailModel();
			tempSdm.setNum(num);
			tempSdm.setGm(gm);
			tempSdm.setSm(sm);
			storeDetailDao.save(tempSdm);
		}
		
		//3.Add a opteration detail log
		OperDetailModel opdm = new OperDetailModel();
		opdm.setType(OperDetailModel.OPER_TYPE_OF_IN);
		opdm.setOperTime(System.currentTimeMillis());
		opdm.setNum(num);
		opdm.setEm(login);
		opdm.setGm(gm);
		opdm.setSm(sm);
		operDetailDao.save(opdm);
		
		//4.If all goods in current order are in store, change the type of the order.
		Long orderUuid = tempOdm.getOm().getUuid();
		OrderModel tempOm = orderDao.get(orderUuid);
		Set<OrderDetailModel> odms = tempOm.getOdms();
		for(OrderDetailModel tOdm : odms){
			if(tOdm.getSurplus() != 0){
				return tempOdm;
			}
		}
		tempOm.setType(OrderModel.ORDER_TYPE_OF_BUY_COMPLETE);
		tempOm.setEndTime(System.currentTimeMillis());
		return tempOdm;
	}
}
