package service;

import mapper.ArticleTypeMapper;
import mapper.ShopCarMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.ShopCar;
import until.DatabaseConnection;

import java.util.List;

public class ShopCarService {
    private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection();
    public List<ShopCar> SelectByUserId(String Userid)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
          ShopCarMapper shopCarMapper   =sqlSession.getMapper(ShopCarMapper.class);
           List<ShopCar> shopCars = shopCarMapper.SelectByUserId(Userid);
        sqlSession.close();
           return  shopCars;
    }

    public boolean updateNum(int articleId ,int num,int userId)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ShopCarMapper shopCarMapper   =sqlSession.getMapper(ShopCarMapper.class);
       Boolean show = shopCarMapper.updateNum(articleId,num,userId);
        sqlSession.close();
        return show;
    }
    public  void addShow(ShopCar shopCar)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ShopCarMapper shopCarMapper   =sqlSession.getMapper(ShopCarMapper.class);
        shopCarMapper.addShop(shopCar);
        sqlSession.close();
    }
    public void  delShop(int id)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ShopCarMapper shopCarMapper   =sqlSession.getMapper(ShopCarMapper.class);
        shopCarMapper.delShop(id);
        sqlSession.close();
    }
}
