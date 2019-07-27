package com.monkeyc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cookiesServlet")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cookie
        //内置对象(page，request，response，session，application，exception，ServletContext，ServletConfig)
        //request和response在Servlet中是内置对象，总共（8）个，Tomcat帮你自己new好，之需要自己用就行了
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();




        for(int i = 0;i < 3;i++){
            Cookie cookie = new Cookie("cookieKey-"+i,"cookieValue-"+i);
            response.addCookie(cookie);

            cookie = new Cookie("PersistentCookieKey-"+i,"PersistentCookieValue-"+i);
            cookie.setMaxAge(36000);
            response.addCookie(cookie);

        }

        out.append("<html>")
                .append("<head><title>CookieServletDemo</title></head>")
                .append("<body>")
                .append("<a href = 'ShowServlet'> Go To Show Cookie </a>")

                .append("</body>")
                .append("</html>");
    }
}
