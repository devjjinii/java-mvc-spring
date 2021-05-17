package com.jin.mvc.web.frontcontroller.v2.controller;

import com.jin.mvc.domain.member.Member;
import com.jin.mvc.domain.member.MemberRepository;
import com.jin.mvc.web.frontcontroller.MyView;
import com.jin.mvc.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // model 데이터 보관
        req.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
