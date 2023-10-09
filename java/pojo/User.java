package pojo;

import java.util.Date;

/**
 * User 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String loginName;
	private String password;
	private String name;
	private int sex;
	private String email;
	private String phone;
	private String address;  //住址
	private int role;//1：表示买家   2：表示卖家
	private Date createDate;   //创建时间
	private int disabled;//0：新建   1：已激活
	private String active; //是否有效

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	public String getLoginName(){
		return this.loginName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSex(int sex){
		this.sex = sex;
	}
	public int getSex(){
		return this.sex;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setRole(int role){
		this.role = role;
	}
	public int getRole(){
		return this.role;
	}
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	public Date getCreateDate(){
		return this.createDate;
	}
	public void setDisabled(int disabled){
		this.disabled = disabled;
	}
	public int getDisabled(){
		return this.disabled;
	}
	public void setActive(String active){
		this.active = active;
	}
	public String getActive(){
		return this.active;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", email=" + email + ", phone=" + phone + ", address=" + address + ", role=" + role
				+ ", createDate=" + createDate + ", disabled=" + disabled + ", active=" + active + "] " ;
	}

}