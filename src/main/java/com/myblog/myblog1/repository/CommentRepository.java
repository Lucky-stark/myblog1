package com.myblog.myblog1.repository;

import com.myblog.myblog1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
