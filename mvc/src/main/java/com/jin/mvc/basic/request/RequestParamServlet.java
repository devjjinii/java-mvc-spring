package com.jin.mvc.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=27
 * **/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requestParamServlet");

        // 전체 파라미터
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));

        // 단일 파라미터
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        // 복수 파라미터  ?username=jin&username=jin2  // getParameterValues
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }

    }
}
