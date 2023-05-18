package com.xxx.login.servlet;

import com.xxx.login.entity.MessageMode;
import com.xxx.login.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    //需要调用service层的方法所以实例化UserService对象
    //UserService userService = new UserService();

    /**
     * 用户登录
     * 1. 接收客户端的请求（接收参数：姓名，密码）
     * 2. 调用service层的方法(userLogin)，返回消息模型对象(MessageMode)
     * 3. 判断消息模型的状态码
     * 如果状态码是失败
     * 将消息模型对象设置到request作用域中，请求转发跳转到login.jsp
     * 如果状态码是成功
     * 将消息模型对象中的用户信息设置到session作用域中，重定向到index.jsp
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收客户端的请求（接收参数：姓名，密码）
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        //2. 调用service层的方法，返回消息模型对象(MessageMode)
        /*UserDao userDao=new UserDao();
        userDao.login(uname);*/
        MessageMode messageMode = new MessageMode();
        try {
            messageMode = UserService.userLogin(uname, upwd);
        } catch (Exception e) {
            Exception exception;
        }
        //3. 判断消息模型的状态码
            if (messageMode.getCode() == 1) {  //成功
                //将消息模型对象中的用户信息设置到session作用域中，重定向到index.jsp
                request.getSession().setAttribute("user", messageMode.getObject());
                response.sendRedirect("index.jsp");
            } else {  //失败
                //将消息模型对象设置到request作用域中，请求转发跳转到login.jsp
                request.setAttribute("messageMode", messageMode);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            response.getWriter().write("11111");
        response.getWriter().write("欢迎");
        response.getWriter().println(messageMode);

    }
}
