package web;

import pojo.Article;
import service.ArticleService;
import service.ArticleTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articleServlet")
public class ArticleServlet extends HttpServlet {
    private ArticleService service =new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=  request.getParameter("id");
   Article article=service.SelectArticle(Integer.parseInt(id));

  request.getSession().setAttribute("article",article);
        String contextPath=request.getContextPath();
  response.sendRedirect(contextPath+"/ProductPage/ProductPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
