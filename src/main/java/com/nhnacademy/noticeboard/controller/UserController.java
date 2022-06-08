package com.nhnacademy.noticeboard.controller;

import com.nhnacademy.noticeboard.domain.UserDto;
import com.nhnacademy.noticeboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute UserDto user,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request) {
        if (userService.matchs(user)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());
            return "redirect:" + redirectURL;
        } else {
            return "loginForm";
        }
    }

}
