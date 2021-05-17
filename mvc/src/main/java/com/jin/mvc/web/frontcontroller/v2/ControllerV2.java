package com.jin.mvc.web.frontcontroller.v2;

import com.jin.mvc.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // 반환
    MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
