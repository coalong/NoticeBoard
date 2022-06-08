package com.nhnacademy.noticeboard.repository;

import com.nhnacademy.noticeboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
