package web;

import pojo.User;
import service.UserService;

//import javax.servlet.*;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   UserService service= new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
String remember= request.getParameter("remember");
            User userDemo=new User();
            userDemo.setLoginName(username);
            userDemo.setPassword(password);

         User user=service.GetLoginNameAndPassword(username,password);
         response.setContentType("text/html;charset=utf-8");
            PrintWriter writer =response.getWriter();
        if(user!=null)
          {
              if("1".equals(remember))
              {
                  //发送Cookie
                  Cookie cookieName =new Cookie("username",username);
                  Cookie cookiePassword=new Cookie("password",password);
                  cookieName.setMaxAge(60*60*24*7);//存活时间
                  cookiePassword.setMaxAge(60*60*24*7);
                  response.addCookie(cookieName);
                  response.addCookie(cookiePassword);

              }

              HttpSession session =request.getSession();
              session.setAttribute("user",user);

           String contextPath=request.getContextPath();
             response.sendRedirect("DeleteLoginSessionServlet");




          }
        else
            {
/*request.setAttribute("login_massage","用户名或密码错误");
request.getRequestDispatcher("Login/login.jsp").forward(request,response);*/
                String script="<script>alert( '用户名或密码错误，请重新登陆' );location.href='/GuowuShangChengWeb/Login/login.jsp'</script>";
                response.getWriter().println(script);

            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
