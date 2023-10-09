package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    @Select("select * from ec_order_item where ORDER_ID=${id}")
    @ResultMap("OrderItemMapper")
       List <OrderItem> SelectByOrderId(int id);

    @Insert("insert into ec_order_item values (${orderId},${articleId},${orderNum})")
    void addOrderItem(OrderItem orderItem);
}
