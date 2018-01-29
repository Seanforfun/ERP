package ca.mcmaster.erp.auth.emp.model;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 29, 2018 1:43:48 PM
 */
public class EmpModel {
	private Long uuid;
	private String username;
	private String name;
	private String password;
	private Integer age;
	private Double weight;
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
