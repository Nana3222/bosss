package web;

import pojo.ShopCar;
import service.ShopCarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addArticleServlet")
public class addArticleServlet extends HttpServlet {
    private ShopCarService service=new ShopCarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
      int id= Integer.parseInt( request.getParameter("id"));
       int num= Integer.parseInt(request.getParameter("num"));
       int userId=Integer.parseInt(request.getParameter("userId"));

       boolean  show = service.updateNum(id,num,userId);
        if (!show) {
            ShopCar shopCar =new ShopCar();
            shopCar.setArticleId(id);
            shopCar.setBuyNum(num);
            shopCar.setUserId(userId);
            service.addShow(shopCar);
        }

          String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/ProductPage/ProductPage.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
