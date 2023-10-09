package until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DatabaseConnection {
   private  static   SqlSessionFactory sqlSessionFactory;
    //静态代码块会随着类的加载而执行，且只执行一次
    static
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public static SqlSessionFactory GetConnection() {
        //第一步 加载mybatis 核心配置文件，获取SqlSessionFactory

     return sqlSessionFactory;







    }

   /* public static void main(String[] args)  throws Exception{

        String username ="admin";
        String password ="123456";

        User userDemo=new User();
        userDemo.setLoginName(username);
        userDemo.setPassword(password);
        UserMapper userMapper=  DatabaseConnection.GetConnection();
       User user= userMapper.GetLoginNameAndPassword(userDemo);
        if(user!=null)
            System.out.println("登录成功");
    }*/
}
