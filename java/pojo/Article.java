package pojo;

/**
 * Article 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class Article implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;//标题
	private String supplier;//供应商
	private double price;    //价格
	private double discount;//折扣
	private String locality;//出产地
	private java.util.Date putawayDate;//上架时间
	private int storage;//库存
	private String image;   //图片
	private String description;  //商品描述
	private String typeCode;     //类型编号
	private java.util.Date createDate;   //创建时间
	private String disabled;   
	
	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	public String getSupplier(){
		return this.supplier;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public double getPrice(){
		return this.price;
	}
	public void setDiscount(double discount){
		this.discount = discount;
	}
	public double getDiscount(){
		return this.discount;
	}
	public void setLocality(String locality){
		this.locality = locality;
	}
	public String getLocality(){
		return this.locality;
	}
	public void setPutawayDate(java.util.Date putawayDate){
		this.putawayDate = putawayDate;
	}
	public java.util.Date getPutawayDate(){
		return this.putawayDate;
	}
	public void setStorage(int storage){
		this.storage = storage;
	}
	public int getStorage(){
		return this.storage;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return this.image;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setTypeCode(String typeCode){
		this.typeCode = typeCode;
	}
	public String getTypeCode(){
		return this.typeCode;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setDisabled(String disabled){
		this.disabled = disabled;
	}
	public String getDisabled(){
		return this.disabled;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", supplier=" + supplier + ", price=" + price + ", discount="
				+ discount + ", locality=" + locality + ", putawayDate=" + putawayDate + ", storage=" + storage
				+ ", image=" + image + ", description=" + description + ", typeCode=" + typeCode + ", createDate="
				+ createDate + ", disabled=" + disabled + "]";
	}

}