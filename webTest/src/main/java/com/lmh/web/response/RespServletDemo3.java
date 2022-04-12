package com.lmh.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/*
* 响应字符数据，设置字符数据的响应体
*
* */
@WebServlet("resp3")

public class RespServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        //用这一句来替代response.setHeader("content-type","text/html");
            //因为这一句既能设置contenttype又能设置字符编码
        PrintWriter writer = response.getWriter();
       // response.setHeader("content-type","text/html");
        writer.write("<h1>aaaaa</h1>");
        /*
        * 细节
            *不需要关闭字符流，response销毁时会自动关闭
            * 中文会乱码
                 //response.setContentType("text/html;charset=utf-8");
                //用这一句来替代response.setHeader("content-type","text/html");
                //因为这一句既能设置contenttype又能设置字符编码
        *
        * */

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
