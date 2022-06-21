package com.nhnacademy.noticeboard.service;

import com.nhnacademy.noticeboard.domain.PostDto;
import com.nhnacademy.noticeboard.entity.Post;

import java.util.List;

public interface PostService {
    void register(PostDto postDto);

    List<Post> viewAllPosts();
}
