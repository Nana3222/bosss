package pojo;

import java.util.List;

/**
 * Order 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class Order implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String orderCode;   //订单编号
	private java.util.Date createDate;  //订单创建时间
	private java.util.Date sendDate;  //订单结束时间
	private String status;  //订单状态
	private double amount;  //订单总数
	private int userId;     //用户id
	
	private List<OrderItem> items;//封装订单明细数据

	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setOrderCode(String orderCode){
		this.orderCode = orderCode;
	}
	public String getOrderCode(){
		return this.orderCode;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setSendDate(java.util.Date sendDate){
		this.sendDate = sendDate;
	}
	public java.util.Date getSendDate(){
		return this.sendDate;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public double getAmount(){
		return this.amount;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", createDate=" + createDate + ", sendDate=" + sendDate
				+ ", status=" + status + ", amount=" + amount + ", userId=" + userId + ", items=" + items + "]";
	}
	
	

}