package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.Order;

import java.util.List;

public interface OrderMapper {
    @Select("select *from ec_order where USER_ID =${id}")
    @ResultMap("OrderMapper")
     List<Order> SelectByUserId(int id);


    void addOrder(Order order);


    Order  SelectById(String code);

}
