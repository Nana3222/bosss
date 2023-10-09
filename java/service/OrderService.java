package service;

import mapper.OrderMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Order;
import until.DatabaseConnection;

import java.util.List;

public class OrderService {
    private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection();
   public   List<Order> SelectByUserId(int id)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
      OrderMapper orderMapper   =sqlSession.getMapper(OrderMapper.class);
      List <Order> orderList =orderMapper.SelectByUserId(id);
      sqlSession.close();
      return orderList;
    }

    public  void addOrder(Order order)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        OrderMapper orderMapper   =sqlSession.getMapper(OrderMapper.class);
        orderMapper.addOrder(order);
        sqlSession.close();
    }

    public Order SelectById(String code)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        OrderMapper orderMapper   =sqlSession.getMapper(OrderMapper.class);
        Order orderList = orderMapper.SelectById(code);
        sqlSession.close();
        return  orderList;
    }

}
