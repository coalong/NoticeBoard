package com.nhnacademy.noticeboard.service;

import com.nhnacademy.noticeboard.domain.UserDto;

public interface UserService {
    boolean matchs(UserDto user);
}
