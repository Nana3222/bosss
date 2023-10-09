package web;

import pojo.Article;
import pojo.User;
import service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectArticleServlet")
public class SelectArticleServlet extends HttpServlet {
    private ArticleService service =new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       String searchName=request.getParameter("search");
        System.out.println(searchName);
    List<Article> articleList=service.SelectByName(searchName);
   request.getSession().setAttribute("articleList",articleList);
    User user= (User) request.getSession().getAttribute("user");
   if(user.getRole()==1)
   {
       String contextPath=request.getContextPath();
       response.sendRedirect(contextPath+"/Page/page.jsp");
   }
   else
       {
           String contextPath=request.getContextPath();
           response.sendRedirect(contextPath+"/Page/ManagerPage.jsp");
       }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
