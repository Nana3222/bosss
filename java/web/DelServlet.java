package web;

import service.ArticleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
    private ArticleService service=new ArticleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String id= request.getParameter("id1");
  service.DelArticle(Integer.parseInt(id));

        response.sendRedirect("ArticleTypeServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
