package com.nhnacademy.noticeboard.controller;

import com.nhnacademy.noticeboard.domain.PostDto;
import com.nhnacademy.noticeboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/insertPost")
    public String Post() {
        return "postForm";
    }

    @PostMapping("/insertPost")
    public String doPost(@ModelAttribute PostDto postDto,
                         HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userId = (String) session.getAttribute("userId");

        postService.register(postDto);

        return null;
    }
}
