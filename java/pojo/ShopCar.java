package pojo;

/**
 * ShopCar 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class ShopCar implements java.io.Serializable{

	private Integer id;
	private Integer articleId;   //商品编号
	private Integer buyNum;      //购买数量
	private Integer userId;      //购买用户id
	private Article article;//物品信息
	
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", articleId=" + articleId + ", buyNum=" + buyNum + ", userId=" + userId
				+ ", article=" + article + "]";
	}
	
	
	
	
}