package com.nhnacademy.noticeboard.domain;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String contents;
    private String userId;
}
