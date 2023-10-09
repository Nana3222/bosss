package web;

import pojo.User;
import service.ShopCarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DelShopCarServlet")
public class DelShopCarServlet extends HttpServlet {
    private ShopCarService service=new ShopCarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    String id =request.getParameter("id");


        service.delShop(Integer.parseInt(id));
        String contextPath=request.getContextPath();
        User user= (User) request.getSession().getAttribute("user");
        response.sendRedirect( contextPath+"/ShoppingCarServlet?userId="+user.getId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
