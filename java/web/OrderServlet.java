package web;

import pojo.Article;
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
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService service=new OrderService();
    private OrderItemService orderItemService =new OrderItemService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     User user= (User) request.getSession().getAttribute("user");
        System.out.println(user);
          int  UserId= user.getId();
        List<Order> orderList= service.SelectByUserId(UserId);
        System.out.println(orderList);
        for(Order i:orderList)
        {
            List<OrderItem> orderItems = orderItemService.SelectByOrderId(i.getId());
            for (OrderItem o:orderItems)
            {
                Article article = new ArticleService().SelectArticle(o.getArticleId());
                o.setArticle(article);
            }
            i.setItems(orderItems);
        }

       request.getSession().setAttribute("orderList",orderList);
        String contextPath=request.getContextPath();
        response.sendRedirect(contextPath+"/Page/OrderItemPage.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
