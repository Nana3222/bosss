package service;

import mapper.OrderItemMapper;
import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.OrderItem;
import until.DatabaseConnection;

import java.util.List;

public class OrderItemService {
    private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection();
    public List <OrderItem> SelectByOrderId(int id)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        OrderItemMapper orderItemMapper  =sqlSession.getMapper(OrderItemMapper.class);
      List<OrderItem>orderItemList =orderItemMapper.SelectByOrderId(id);
        sqlSession.close();
        return orderItemList;
    }
   public  void addOrderItem(OrderItem orderItem)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        OrderItemMapper orderItemMapper  =sqlSession.getMapper(OrderItemMapper.class);
        orderItemMapper.addOrderItem(orderItem);
        sqlSession.close();
    }
}
