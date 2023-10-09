package web;

import pojo.Article;
import pojo.ArticleType;
import pojo.User;
import service.ArticleService;
import service.ArticleTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ArticleTypeServlet")
public class ArticleTypeServlet extends HttpServlet {
  private   ArticleTypeService service=new ArticleTypeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     List<ArticleType > articleType =service.SelectAllArticleTypeName();
        List <Article> articleList= new ArticleService().SelectAllArticle();
        request.getSession().setAttribute("articleList",articleList);//发送商品信息到浏览器
        request.getSession().setAttribute("articleType",articleType);

        response.setContentType("text/html;charset=utf-8");
        if(request.getSession().getAttribute("user")==null)//如果当前用户没有登录
        {
            String Script= "        <script>\n" +
                    "            document.getElementById(\"title\").style.display='none'\n" +
                    "            document.getElementById(\"login2\").style.display=''\n" +
                    "            document.getElementById(\"login1\").style.display='none'\n" +
                    "        </script>";
       request.getSession().setAttribute("Script",Script);

        }
 User user = (User) request.getSession().getAttribute("user");
        if(user!=null)
        {
            int role=user.getRole();
            if(role==2)
            {
                String contextPath=request.getContextPath();
                response.sendRedirect(contextPath+"/Page/ManagerPage.jsp");
                return;
            }

        }

        String contextPath=request.getContextPath();
        response.sendRedirect(contextPath+"/Page/page.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
