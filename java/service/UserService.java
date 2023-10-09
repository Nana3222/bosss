package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import until.DatabaseConnection;

public class UserService {
   private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection() ;
     public User GetLoginNameAndPassword(String username ,String password)
     {
         SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
         UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
         User user2 =userMapper.GetLoginNameAndPassword(username,password);
             sqlSession.close();
              return  user2;


     }
     public  void  adduser(User user)
     {
         SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
         UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
         userMapper.adduser(user);
         sqlSession.close();
     }
      public  boolean SelectByName(User user)
      {
          SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
          UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
          User u =userMapper.SelectByUserName(user.getLoginName());
          if(u==null)
          {
              //用户名不存在
              userMapper.adduser(user);
          }
          sqlSession.close();
          return u==null;
      }
}
