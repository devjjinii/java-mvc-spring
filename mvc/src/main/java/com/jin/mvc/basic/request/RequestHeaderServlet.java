package com.jin.mvc.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printHeader(req);
    }

    private void printHeader(HttpServletRequest req) {
        System.out.println("-- Header start --");

//        Enumeration<String> headerNames = req.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + headerName);
//        }

        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        System.out.println("-- Header end --");

        System.out.println("request.getServerName() = " + req.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + req.getServerPort()); //Host 헤더

        // 쿠키
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            } }
        // get 방식

    }
}
