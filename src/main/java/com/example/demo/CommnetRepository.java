package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface CommnetRepository extends MyRepository<Comment, Long>{
    List<Comment> findByCommentContains(String keyword);

    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

    @Async
    Future<List<Comment>> findByCommentContains(String keyword, Pageable pageable);

    List<Comment> findByCommentOrderByLikeCountDesc();

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);
}
