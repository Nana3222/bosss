package pojo;

/**
 * OrderItem 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class OrderItem implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int orderId;   //订单id
	private int articleId;  //商品id
	private int orderNum;   //订单数量
	private Article article;//封装物品信息

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	/** setter and getter method */
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	public int getOrderId(){
		return this.orderId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}
	public int getArticleId(){
		return this.articleId;
	}
	public void setOrderNum(int orderNum){
		this.orderNum = orderNum;
	}
	public int getOrderNum(){
		return this.orderNum;
	}
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", articleId=" + articleId + ", orderNum=" + orderNum + ", article="
				+ article + "]";
	}

}