package mapper;

import org.apache.ibatis.annotations.Select;
import pojo.ArticleType;

import java.util.List;

public interface ArticleTypeMapper {
    @Select("select * from ec_article_type")
    List<ArticleType> SelectAll();
}
