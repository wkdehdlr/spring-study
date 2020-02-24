package com.example.demo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(value = "Comment.account")
    Optional<Comment> getById(Long id);

    <T> List<T> findByAccount_Id(Long id, Class<T> type);
}
