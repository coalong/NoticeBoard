package com.nhnacademy.noticeboard.domain;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDto {
    @NotNull
    private String id;
    @NotNull
    private String password;
}
