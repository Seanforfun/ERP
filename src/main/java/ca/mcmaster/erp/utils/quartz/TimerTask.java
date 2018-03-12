package ca.mcmaster.erp.utils.quartz;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.invoice.storedetail.service.ebi.StoreDetailEbi;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 11, 2018 6:35:00 PM
 */
public class TimerTask {
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
	@Resource(name="storeDetailEbi")
	private StoreDetailEbi storeDetailEbi;
	@Resource(name="mailSender")
	private MailSender mailSender;
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
	
	public void storeWarning(){
		/*select
		g.name,
		(sum(sd.num) < g.minNum) as rmin,
		(sum(sd.num) > g.maxNum) as rmax
		from
			tbl_storedetail sd
		left outer join
			tbl_goods g
		on
			g.uuid = sd.goodsUuid
		group by
			sd.goodsUuid*/
		Boolean sendFlag = false;
		List<Object[]> warningList = storeDetailEbi.getWarningInfo();
		//objs[0]:name; objs[1]:rmin; objs[2]:rmax
		StringBuilder sb = new StringBuilder();
		for(Object[] objs : warningList){
			
			if(((BigInteger)objs[1]).intValue() == 1){
				sb.append("商品【");
				String goodsName = objs[0].toString();
				sb.append(goodsName);
				sb.append("】库存低于下限，请开始补货。");
				sb.append("\r\n");
				sendFlag = true;
				continue;
			}
			if(((BigInteger)objs[2]).intValue() == 1){
				sb.append("商品【");
				String goodsName = objs[0].toString();
				sb.append(goodsName);
				sb.append("】库存超过上限，请停止补货。");
				sb.append("\r\n");
				sendFlag = true;
			}
		}
//		System.out.println(sb.toString());
		if(sendFlag){
			SimpleMailMessage smm = new SimpleMailMessage();
			smm.setFrom("Xiao.Botao@outlook.com");
			smm.setTo("xbtdx@126.com");
			smm.setSentDate(new Date());
			smm.setSubject("库存预警["+FormatUtils.formatDateTime(System.currentTimeMillis())+"]");
			smm.setText(sb.toString());
			mailSender.send(smm);
			System.out.println("已发送邮件");
		}
	}
}
