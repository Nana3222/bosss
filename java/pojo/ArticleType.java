package pojo;

/**
 * ArticleType 数据传输类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2016-06-21 14:07:38
 * @version 1.0
 */
public class ArticleType implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String code;   //编号
	private String name;   //名字
	private String remark;  //商品简介

	/** setter and getter method */
	public void setCode(String code){
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}

}