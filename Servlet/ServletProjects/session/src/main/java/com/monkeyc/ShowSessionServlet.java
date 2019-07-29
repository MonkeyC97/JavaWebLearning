package com.monkeyc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet_session")
public class ShowSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置charset时，是;不是:
        response.setContentType("text/html;charset:UTF-8");
        PrintWriter out = response.getWriter();

        // 测试Session
        HttpSession httpSession = request.getSession(true);

        String message = null;// 如果是第一次来  就是newer  如果多次访问就是  older

        Integer accessCount = (Integer)httpSession.getAttribute("accessCount");

        if(accessCount == null) {
            accessCount = new Integer(0);
            message = "newer";
            httpSession.setAttribute("accessCount",accessCount);
        }else {
            accessCount = new Integer(accessCount.intValue()+1);
            message = "older";
        }
        out.append("<html>")
                .append("<head><title>CookieServletDemo</title></head>")
                .append("<body>")
                .append("<h1>'"+message+"'</h1>")
                .append("<table border='1' align='center'>")
                .append("<tr>")
                .append("<td>SessionID</td>")
                .append("<td>'"+httpSession.getId()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Session Create Time</td>")
                .append("<td>'"+httpSession.getCreationTime()+"'</td>")
                .append("</tr>")

                .append("<tr>")
                .append("<td>Session Access Last Time</td>")
                .append("<td>'"+httpSession.getLastAccessedTime()+"'</td>")
                .append("</tr>")

                .append("</table>")
                .append("</body>")
                .append("</html>");
    }
}