package com.nhnacademy.noticeboard.controller;

import com.nhnacademy.noticeboard.domain.PostDto;
import com.nhnacademy.noticeboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시물 등록
    @GetMapping("/insertPost")
    public String post() {
        return "postForm";
    }

    @PostMapping("/insertPost")
    public String doPost(@ModelAttribute PostDto postDto,
                         HttpServletRequest request) {
        postDto.setUserId((String) request.getSession(false).getAttribute("userId"));
        postService.register(postDto);
        return "noticeBoard";
    }

    // 게시물 조회
    @GetMapping("/viewNoticeBoard")
    public String viewNoticeBoard(ModelMap modelMap) {
        modelMap.put("noticeBoard", postService.viewAllPosts());
        return "noticeBoard";
    }
}
