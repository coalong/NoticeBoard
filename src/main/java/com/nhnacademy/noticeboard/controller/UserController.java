package com.nhnacademy.noticeboard.controller;

import com.nhnacademy.noticeboard.domain.UserDto;
import com.nhnacademy.noticeboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            return "loginForm";
        } else {
            return "noticeBoard";
        }
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute UserDto user,
                          HttpServletRequest request) {
        if (userService.matchs(user)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());
            return "noticeBoard";
        } else {
            return "redirect:/login";
        }
    }

}
