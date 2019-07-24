package com.monkeyc.servlet;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/loginServlet")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //to do something
        String forme_name = req.getParameter("username");
        String form_pass = req.getParameter("password");
        if("monkeyc".equals(forme_name) &&"123456".equals(form_pass)){
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("failure.jsp").forward(req,resp);
        }
    }
}
