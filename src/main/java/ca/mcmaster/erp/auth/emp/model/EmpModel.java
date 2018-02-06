package ca.mcmaster.erp.auth.emp.model;

import java.util.HashMap;
import java.util.Map;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:04:47 PM
 */
public class EmpModel {
	public static final String LOGIN_EMP = "login_emp";
	public static final Integer EM_INDEX_GENDER_MALE = 0;
	public static final Integer EM_INDEX_GENDER_FRMALE = 1;
	public static final String EM_VIEW_GENDER_MALE = "male";
	public static final String EM_VIEW_GENDER_FRMALE = "female";
	public static final Map<Integer, String> genderMap = new HashMap<Integer, String>();
	static{
		genderMap.put(EM_INDEX_GENDER_MALE, EM_VIEW_GENDER_MALE);
		genderMap.put(EM_INDEX_GENDER_FRMALE, EM_VIEW_GENDER_FRMALE);
	}
	
	private Integer uuid;
	private String username;
	private String name;
	private String password;
	private String email;	
	private String tele;
	private Integer gender;	//1-male; 0-female
	private Long birthday;
	private DeptModel dm;
	private String address;
	private String birthdayView;
	private String genderView;
	private Long lastLoginTime;
	private String lastLoginTimeView;
	public String getLastLoginTimeView() {
		return lastLoginTimeView;
	}
	private String lastLoginIp;
	private Integer loginTimes;
	public Long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		if(lastLoginTime != null){
			lastLoginTimeView = FormatUtils.formatDate(lastLoginTime);
		}
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getGenderView() {
		return genderView;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DeptModel getDm() {
		return dm;
	}
	public void setDm(DeptModel dm) {
		this.dm = dm;
	}
	public Long getBirthday() {
		return birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
		if(null != birthday)
			this.birthdayView = FormatUtils.formatDate(birthday);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
		if(null != gender){
			genderView = genderMap.get(gender);
		}
	}
	public String getBirthdayView() {
		return birthdayView;
	}
}
