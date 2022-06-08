package com.nhnacademy.noticeboard.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginCheckIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);

        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("userId"))) {
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }
            return true;
    }
}
