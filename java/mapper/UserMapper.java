package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {
    @Select(" select * from ec_user  where LOGIN_NAME = #{loginName} and password=#{password}")
    @ResultMap("UserMapper")
    User GetLoginNameAndPassword(@Param("loginName")String loginName, @Param("password")String password);

    @Select("select *from ec_user where LOGIN_NAME=#{loginName}")
    @ResultMap("UserMapper")
   User SelectByUserName(String loginName);

    @Insert("insert into ec_user VALUES(null,#{loginName},#{password},#{name},#{sex},null,#{phone},#{address},#{role},null,null,null)")
   void adduser(User user);

}