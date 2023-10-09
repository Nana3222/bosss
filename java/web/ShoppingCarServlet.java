package web;

import pojo.Article;
import pojo.ShopCar;
import service.ArticleService;
import service.ShopCarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
    private ShopCarService service=new ShopCarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userId= request.getParameter("userId");
        List<ShopCar> shopCarList= service.SelectByUserId(userId);

        for (ShopCar shopCar:shopCarList){
            Article article= new ArticleService().SelectArticle(shopCar.getArticleId());
            shopCar.setArticle(article);

        }


        request.getSession().setAttribute("shopCarList",shopCarList);
        String contextPath=request.getContextPath();
        response.sendRedirect(contextPath+"/ShoppingCarPage/ShoppingCarPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
