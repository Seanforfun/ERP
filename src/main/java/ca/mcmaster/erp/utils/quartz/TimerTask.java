package ca.mcmaster.erp.utils.quartz;

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
		List<Object[]> warningList = storeDetailEbi.getWarningInfo();
		for(Object[] objs : warningList){
			System.out.println(objs[0]);
			System.out.println(objs[1]);
			System.out.println(objs[2]);
		}
		
//		SimpleMailMessage smm = new SimpleMailMessage();
//		smm.setFrom("Xiao.Botao@outlook.com");
//		smm.setTo("xbtdx@126.com");
//		smm.setSentDate(new Date());
//		smm.setSubject("ø‚¥Ê‘§æØ["+FormatUtils.formatDateTime(System.currentTimeMillis())+"]");
//		smm.setText("≤‚ ‘” º˛");
//		mailSender.send(smm);
	}
}
