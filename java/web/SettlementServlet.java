package web;

import pojo.Order;
import pojo.OrderItem;
import pojo.User;
import service.ArticleService;
import service.OrderItemService;
import service.OrderService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SettlementServlet")
public class SettlementServlet extends HttpServlet {
     private OrderService orderService=new OrderService();
     private OrderItemService orderItemService=new OrderItemService();
     private ArticleService articleService=new ArticleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int  articleId= Integer.parseInt(request.getParameter("articleId"));
      double price= Double.parseDouble(request.getParameter("price"));
      int articleNum= Integer.parseInt(request.getParameter("articleNum"));
      User user = (User) request.getSession().getAttribute("user");
      int UserId=user.getId();


        Date date = new Date();
        Order order = new Order();
        order.setCreateDate(date);

        SimpleDateFormat simpLeDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpLeDateFormat.format(date);

        String out="PC"+format+"12";

        order.setOrderCode(out);
        order.setAmount(price);
        order.setUserId(UserId);
        orderService.addOrder(order);

        Order order1 = orderService.SelectById(out);
       OrderItem orderItem=new OrderItem();

               orderItem.setOrderId(order1.getId());
               orderItem.setArticleId(articleId);
               orderItem.setOrderNum(articleNum);
               orderItemService.addOrderItem(orderItem);

        //减少对应商品库存
        articleService.UpdateStorage(articleId,articleNum);

        String contextPath=request.getContextPath();
        response.sendRedirect(contextPath+"/OrderServlet");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
