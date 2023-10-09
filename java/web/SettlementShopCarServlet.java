package web;
import pojo.Order;
import pojo.OrderItem;
import pojo.User;
import service.ArticleService;
import service.OrderItemService;
import service.OrderService;
import service.ShopCarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@WebServlet("/SettlementShopCarServlet")
public class SettlementShopCarServlet extends HttpServlet {
    private OrderService orderService=new OrderService();
    private OrderItemService orderItemService=new OrderItemService();
    private ArticleService articleService=new ArticleService();
    private ShopCarService shopCarService=new ShopCarService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        String prices=request.getParameter("prices");
        String nums=request.getParameter("nums");
        String articleIds=request.getParameter("articleIds");
        String ShopCarIds=request.getParameter("ShopCarId");
        int UserId=user.getId();

        for(int i=0;i<prices.split(",").length;i++)
        {
            double price= Double.parseDouble(prices.split(",")[i]);
            int articleNum= Integer.parseInt(nums.split(",")[i]);
            int articleId= Integer.parseInt(articleIds.split(",")[i]);
              int ShopCarId= Integer.parseInt(ShopCarIds.split(",")[i]);

            Date date = new Date();
            Order order = new Order();
            order.setCreateDate(date);

            SimpleDateFormat simpLeDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String format = simpLeDateFormat.format(date);
            Random r = new Random();
            int i1=10;
            int i2= 10+r.nextInt(90);
            String out="PC"+format+i2;

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

            //删除结算商品在购物车的内容
           shopCarService.delShop(ShopCarId);

        }
        String contextPath=request.getContextPath();
        response.sendRedirect(contextPath+"/OrderServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
