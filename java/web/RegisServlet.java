package web;

import pojo.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/regisServlet")
public class RegisServlet extends HttpServlet {
    UserService service =new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //乱码原因tomcat进行url解码 默认字符集是iso-8859-1
      //解决post乱码   post获取数据的方式是reader
        request.setCharacterEncoding("UTF-8");
        /* //解决get乱码  get 获取数据的方法 getQueryString
        * 1.先对乱码数据进行编码：转为字节数组
        * byte[]  bytes=username.getBytes(StandardCharsets.ISO_8859_1)
        * 2.在对字节数组进行解码
        * username =new String(bytes,StandardCharsets)
        *
        *
        * */

        String username= request.getParameter("username");
        String password1= request.getParameter("password1");
        String password2 =request.getParameter("password2");
        int sex= Integer.parseInt(request.getParameter("sex"));
        String name =request.getParameter("name");
        String address=request.getParameter("address");
        String phone= request.getParameter("phone");
        String code = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
        String checkCode= request.getParameter("code");
        String contextPath=request.getContextPath();



        User user = new User();
        user.setPassword(password1);
        user.setLoginName(username);
        user.setSex(sex);
        user.setAddress(address);
        user.setPhone(phone);
        user.setName(name);

        response.setContentType("text/html;charset=utf-8");

if(!code.equals(checkCode))
{
    request.getSession().setAttribute("checkNews","验证码错误");
  response.sendRedirect(contextPath+"/regist/regist.jsp");
    return;
}

      Boolean values=service.SelectByName(user);
        response.setContentType("text/html;charset=utf-8");
        if(values)//为真时 添加用户成功
        {
            String script="<script>alert( '注册成功，点击确定登录' );location.href='/GuowuShangChengWeb/Login/login.jsp'</script>";
            response.getWriter().println(script);

        }
        else
            {

request.getSession().setAttribute("result","用户名已经存在");
                response.sendRedirect(contextPath+"/regist/regist.jsp");

            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
