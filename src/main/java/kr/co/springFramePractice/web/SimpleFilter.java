package kr.co.springFramePractice.web;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@Slf4j
public class SimpleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Filter ==> 필터 TEST");

        HttpSession session = ((HttpServletRequest)request).getSession();

        String username = (String)session.getAttribute("username");
        if(username == null) {
            log.info("새로운 user");
            session.setAttribute("username", "june");
        } else {
            log.info("user --> " + username);
        }

        chain.doFilter(request, response);
        PrintWriter writer = response.getWriter();
        writer.println("Filter ==> 필터 TEST 출력!");
    }
}
