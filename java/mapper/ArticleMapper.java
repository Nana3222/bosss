package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Article;

import java.util.List;

public interface ArticleMapper {
    @Select("select  *from ec_article")
    List<Article> SelectAll();

    @Select("select * from ec_article where id =#{id}")
    Article SelectArticle(int id);

    @Select("select * from ec_article where TITLE like ${name}")
    List<Article>SelectByName(String name);

 @Delete("delete from ec_article where ID =${id}")
    void delArticle(int id);

  @Update("update ec_article set storage= storage-${num} where ID=${articleId}")
    void UpdateStorage (@Param("articleId") int articleId, @Param("num") int num);
}
