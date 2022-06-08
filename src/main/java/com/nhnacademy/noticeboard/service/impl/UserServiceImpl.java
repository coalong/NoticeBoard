package com.nhnacademy.noticeboard.service.impl;

import com.nhnacademy.noticeboard.domain.UserDto;
import com.nhnacademy.noticeboard.entity.User;
import com.nhnacademy.noticeboard.repository.UserRepository;
import com.nhnacademy.noticeboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean matchs(UserDto reqUser) {
        User dbUser = userRepository.findById(reqUser.getId()).orElseThrow();
        if (Objects.equals(dbUser.getPassword(), reqUser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @PostConstruct
    public void insertUser() {
        User user1 = new User("admin", "12345", "관리자", 0);
        userRepository.save(user1);
    }
}
