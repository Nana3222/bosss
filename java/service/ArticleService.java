package service;

import mapper.ArticleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Article;
import until.DatabaseConnection;
import java.util.List;

public class ArticleService {
    private SqlSessionFactory sqlSessionFactory= DatabaseConnection.GetConnection() ;

    public List<Article> SelectAllArticle()
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleMapper articleMapper =sqlSession.getMapper(ArticleMapper.class);

        List<Article> articles= articleMapper.SelectAll();
        sqlSession.close();
return articles;
    }

    public Article SelectArticle(int id)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleMapper articleMapper =sqlSession.getMapper(ArticleMapper.class);
        Article article= articleMapper.SelectArticle(id);
        sqlSession.close();
        return  article;

    }

    public List<Article> SelectByName(String name)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleMapper articleMapper =sqlSession.getMapper(ArticleMapper.class);
        String newName="'%"+name+"%'";
        List<Article> article= articleMapper.SelectByName(newName);
        sqlSession.close();
        return article;
    }
    public void DelArticle(int id )
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleMapper articleMapper =sqlSession.getMapper(ArticleMapper.class);
        articleMapper.delArticle(id);
        sqlSession.close();
    }
    public void UpdateStorage(int articleId,int num)
    {
        SqlSession sqlSession =sqlSessionFactory.openSession(true);//ture时 为自动提交事务
        ArticleMapper articleMapper =sqlSession.getMapper(ArticleMapper.class);
        articleMapper.UpdateStorage(articleId,num);
        sqlSession.close();

    }
}
