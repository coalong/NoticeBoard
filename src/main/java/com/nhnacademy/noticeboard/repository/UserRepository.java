package com.nhnacademy.noticeboard.repository;

import com.nhnacademy.noticeboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
