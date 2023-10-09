package service;

import mapper.ArticleTypeMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.ArticleType;
import until.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeService {
    private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection() ;

   public List<ArticleType> SelectAllArticleTypeName()
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleTypeMapper articleTypeMapper =sqlSession.getMapper(ArticleTypeMapper.class);
    List<ArticleType> articleType=articleTypeMapper.SelectAll();
    ArrayList<ArticleType> array =new ArrayList<>();
        for(ArticleType i: articleType )
        {
            if(i.getCode().length()==4)
            {
                array.add(i);
            }

        }

       sqlSession.close();
       return array;
    }
}
