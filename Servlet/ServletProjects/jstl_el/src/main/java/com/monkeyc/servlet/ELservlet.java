package com.monkeyc.servlet;

import vo.Group;
import vo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ELservlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //测试EL表达式
        //普通字符串
        request.setAttribute("strKey","monkeyc");

        //测试结构体
        Group group = new Group();
        group.setgName("XPU");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("Monkeyc");

        userInfo.setGroup(group);
        request.setAttribute("UserInfoKey",userInfo);

        //测试字符串
        String[] strarray = new String[]{"aa","bb","cc","dd"};
        request.setAttribute("strArrayKey",strarray);

        //测试自定义数组
        UserInfo[] userInfos = new UserInfo[5];
        for(int i = 0; i < userInfos.length; i++){
            UserInfo userInfo1 = new UserInfo();
            userInfo1.setUserName("U_"+i);
            userInfos[i] = userInfo1;
        }

        request.setAttribute("userInfosKey",userInfos);

        //跳转
        request.getRequestDispatcher("jstl_el.jsp").forward(request,response);
    }
}
