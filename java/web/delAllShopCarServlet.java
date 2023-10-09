package web;

import pojo.User;
import service.ShopCarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delAllShopCarServlet")
public class delAllShopCarServlet extends HttpServlet {
    private ShopCarService service=new ShopCarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
     String id=request.getParameter("id");
        System.out.println(id);
       for(int i=0;i<id.split(",").length;i++)
       {
        int ShopCarId=Integer.parseInt(id.split(",")[i]); //将传过来的id做分割后转成int类型存入数组
           service.delShop(ShopCarId);
       }
        User user= (User) request.getSession().getAttribute("user");
        String contextPath=request.getContextPath();
        response.sendRedirect( contextPath+"/ShoppingCarServlet?userId="+user.getId());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
