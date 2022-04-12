package com.lmh.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo2" ,loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    /*
    * init方法会在申请资源时被调用
    *       *loadOnStartup = 1
    *       数值越小越先创建，0和正整数
    * 调用次数：1次
    * */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    /*
    * 提供服务
    * 1、调用时机：当servlet每一次被访问时
    * 2、调用次数：多次
    *
    * */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet");
    }

    /*
    * 销毁方法
    * 1、调用时机：当内存释放或者服务器被关闭的时候调用，servlet方法会被销毁
    * 2、调用次数：一次
    * */
    public void destroy() {
        System.out.println("destroy");
    }
    public String getServletInfo() {
        return null;
    }
    public ServletConfig getServletConfig() {
        return null;
    }

}
