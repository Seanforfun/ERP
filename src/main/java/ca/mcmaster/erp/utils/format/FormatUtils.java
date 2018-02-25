package ca.mcmaster.erp.utils.format;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 4, 2018 7:38:43 PM
 */
public class FormatUtils {
	public static final String formatDate(Long time){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date(time));
	}
	public static final String formatTime(Long time){
		DateFormat df = new SimpleDateFormat("HH-mm-ss");
		return df.format(new Date(time));
	}
	public static final String formatDateTime(Long time){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return df.format(new Date(time));
	}
	public static final String formatMoney(Double money){
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(money);
	}
}
