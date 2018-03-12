package ca.mcmaster.erp.invoice.bill.service.ebo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import ca.mcmaster.erp.invoice.bill.dao.dao.BillDao;
import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.bill.service.ebi.BillEbi;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.utils.jchart.JChartUtils;
import ca.mcmaster.erp.utils.jxl.JxlUtils;

public class BillEbo implements BillEbi {
	@Resource(name="billDao")
	private BillDao billDao;

	public List<Object[]> getBuyBillList(BillQueryModel bqm) {
		return billDao.getBuyBill(bqm);
	}

	public List<OrderDetailModel> getBillByGoods(BillQueryModel bqm) {
		return billDao.getBuyBillDetails(bqm);
	}

	public void writeJChartToOs(OutputStream os, BillQueryModel bqm) throws IOException {
		//通过dao获取数据
		List<Object[]> billList = billDao.getBuyBill(bqm);
		List<Object[]> dataSetList = new ArrayList<Object[]>();
		//objs[1]存储商品的名称，objs[0]存储商品的数量
		for(Object[] objs : billList){
			dataSetList.add(new Object[]{objs[0], ((GoodsModel)objs[1]).getName()});
		}
		JChartUtils.createChart(dataSetList, os);
	}

	public InputStream getExcelStream(BillQueryModel bqm) throws Exception{
		List<Object[]> billList = billDao.getBuyBill(bqm);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		WritableWorkbook w = JxlUtils.cWorkbook(bos);
		WritableSheet sheet = JxlUtils.cSheet(w, 1, "总括");
		
		JxlUtils.setColumnSize(sheet, 1, 8);
		JxlUtils.setColumnSize(sheet, 2, 8);
		JxlUtils.setColumnSize(sheet, 3, 25);
		JxlUtils.setColumnSize(sheet, 4, 25);
		JxlUtils.setColumnSize(sheet, 5, 25);
		
		JxlUtils.setRowSize(sheet, 1, 15);
		JxlUtils.setRowSize(sheet, 1, 37);
		JxlUtils.setRowSize(sheet, 1, 6);
		JxlUtils.setRowSize(sheet, 1, 23);
		
		JxlUtils.merge(sheet, 2,2,2,4);
		JxlUtils.merge(sheet, 3,2,3,5);
		
		Label lab22 = JxlUtils.createLabel(2, 2, "进货统计报表");
		JxlUtils.setLabelSize(lab22, "黑体", 24, Colour.BLACK, Colour.LIGHT_BLUE, 1, "2020");
		JxlUtils.addLabelToSheet(lab22, sheet);
		
		Label lab25 = JxlUtils.createLabel(2, 5, "不限");
		JxlUtils.setLabelSize(lab25, "黑体", 12, Colour.BLACK, Colour.LIGHT_BLUE, 1, "2002");
		JxlUtils.addLabelToSheet(lab25, sheet);
		
		Label lab32 = JxlUtils.createLabel(3, 2, "");
		JxlUtils.setLabelSize(lab32, "黑体", 1, Colour.BLACK, Colour.GRAY_25, 1, "2022");
		JxlUtils.addLabelToSheet(lab32, sheet);
		
		Label lab42 = JxlUtils.createLabel(4, 2, "编号");
		JxlUtils.setLabelSize(lab42, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2220");
		JxlUtils.addLabelToSheet(lab42, sheet);
		
		Label lab43 = JxlUtils.createLabel(4, 3, "厂商");
		JxlUtils.setLabelSize(lab43, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2220");
		JxlUtils.addLabelToSheet(lab43, sheet);
		
		Label lab44 = JxlUtils.createLabel(4, 4, "商品名");
		JxlUtils.setLabelSize(lab44, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2220");
		JxlUtils.addLabelToSheet(lab44, sheet);
		
		Label lab45 = JxlUtils.createLabel(4, 5, "数量");
		JxlUtils.setLabelSize(lab45, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2222");
		JxlUtils.addLabelToSheet(lab45, sheet);
		
		int row  = 5;
		int i = 0;
		Long sumAll = 0L;
		for(Object[] objs:billList){
			Long sum = (Long) objs[0];
			GoodsModel gm = (GoodsModel) objs[1];
			//设置行高
			JxlUtils.setRowSize(sheet, row+i, 30);
			//创建所有单元格
			
			Label lab_data_1 = JxlUtils.createLabel(row+i, 2, i+1+"");
			JxlUtils.setLabelSize(lab_data_1, "宋体", 14, Colour.BLACK, Colour.WHITE, 1, "0120");
			JxlUtils.addLabelToSheet(lab_data_1, sheet);
			
			Label lab_data_2 = JxlUtils.createLabel(row+i, 3, gm.getGtm().getSm().getName());
			JxlUtils.setLabelSize(lab_data_2, "宋体", 14, Colour.BLACK, Colour.WHITE, 1, "0110");
			JxlUtils.addLabelToSheet(lab_data_2, sheet);
			
			Label lab_data_3 = JxlUtils.createLabel(row+i, 4, gm.getName());
			JxlUtils.setLabelSize(lab_data_3, "宋体", 14, Colour.BLACK, Colour.WHITE, 1, "0110");
			JxlUtils.addLabelToSheet(lab_data_3, sheet);
			
			Label lab_data_4 = JxlUtils.createLabel(row+i, 5, sum.toString());
			JxlUtils.setLabelSize(lab_data_4, "宋体", 14, Colour.BLACK, Colour.WHITE, 1, "0112");
			JxlUtils.addLabelToSheet(lab_data_4, sheet);
			
			i++;
			sumAll += sum;
		}
		//设置最后一行高度
		JxlUtils.setRowSize(sheet, row+i , 25);
		//设置最后一行的合并
		JxlUtils.merge(sheet, row+i, 2, row+i, 4);
		
		Label lab_tail_1 = JxlUtils.createLabel(row+i, 2, "总计：");
		JxlUtils.setLabelSize(lab_tail_1, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2220");
		JxlUtils.addLabelToSheet(lab_tail_1, sheet);
		
		Label lab_tail_2 = JxlUtils.createLabel(row+i, 5, sumAll.toString());
		JxlUtils.setLabelSize(lab_tail_2, "黑体", 18, Colour.BLACK, Colour.WHITE, 1, "2222");
		JxlUtils.addLabelToSheet(lab_tail_2, sheet);
		
		w.write();
		w.close();
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
		return inputStream;
	}
}
