package mapper;


import org.apache.ibatis.annotations.*;
import pojo.ShopCar;

import java.util.List;

public interface ShopCarMapper {
    @Select("select * from ec_shopcar where userId=#{id}")
  List<ShopCar> SelectByUserId(String id);

    @Update("update ec_shopcar set buyNum= buyNum+${num} where  articleId=${id} and userId=${userId}" )
   boolean updateNum(@Param("id") int id , @Param("num") int num, @Param("userId") int userId );

    @Insert("insert into ec_shopcar values (null,#{articleId},#{buyNum},#{userId})")
    void addShop(ShopCar shopCar);

    @Delete("delete from ec_shopcar where ID=${id}")
    void delShop(int id);
}
