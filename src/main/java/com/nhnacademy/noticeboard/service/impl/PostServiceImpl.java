package com.nhnacademy.noticeboard.service.impl;

import com.nhnacademy.noticeboard.domain.PostDto;
import com.nhnacademy.noticeboard.entity.Post;
import com.nhnacademy.noticeboard.repository.PostRepository;
import com.nhnacademy.noticeboard.repository.UserRepository;
import com.nhnacademy.noticeboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void register(PostDto postDto) {
        Post post = Post.builder()
                         .user(userRepository.findById(postDto.getUserId()).orElseThrow())
                         .title(postDto.getTitle())
                         .content(postDto.getContents())
                         .createDate(new Date())
                         .build();
        postRepository.save(post);
    }

    @Override
    public List<Post> viewAllPosts() {
        return postRepository.findAll();
    }
}
