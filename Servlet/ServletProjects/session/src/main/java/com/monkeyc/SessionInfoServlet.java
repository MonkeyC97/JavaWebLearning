package com.monkeyc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet
public class SessionInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置charset时，是;不是:
        response.setContentType("text/html;charset:UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession(true);

        out.append("<html>")
                .append("<head><title>CookieServletDemo</title></head>")
                .append("<body>")
                //session的信息
                .append("sessionID："+httpSession.getId()+"</br>")
                .append("newSession？："+httpSession.isNew()+"</br>")
                .append("sessionCreateTime："+new Date(httpSession.getCreationTime())+"</br>")
                .append("session")
                .append("</body>")
                .append("</html>");
    }
}