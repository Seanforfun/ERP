package ca.mcmaster.erp.utils.quartz;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 11, 2018 6:35:00 PM
 */
public class TimerTask {
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
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
		SimpleMailMessage smm = new SimpleMailMessage();
		
		smm.setFrom("Xiao.Botao@outlook.com");
		smm.setTo("xbtdx@126.com");
		
		smm.setSentDate(new Date());
		smm.setSubject("ø‚¥Ê‘§æØ["+FormatUtils.formatDateTime(System.currentTimeMillis())+"]");
		smm.setText("≤‚ ‘” º˛");
		
		mailSender.send(smm);
		
		System.out.println(mailSender);
	}
}
