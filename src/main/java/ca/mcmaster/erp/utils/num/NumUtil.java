package ca.mcmaster.erp.utils.num;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 3, 2018 8:37:21 PM
 */
public class NumUtil {
	public static int serNum = 1;
	public static final int len = 7;
	public static final byte[] zeros = {48, 48, 48, 48, 48, 48};
	public static void main(String[] args) {
		System.out.println(generateOrdeNum());
	}
	public static final String generateOrdeNum(){
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String first = df.format(d) + "";
		Integer num = serNum++;
		int clen = (num + "").length();
		String sec = new String(zeros, 0, len - clen);
		return Long.toHexString(new Long(first + sec + num)).toUpperCase();
	}
}
