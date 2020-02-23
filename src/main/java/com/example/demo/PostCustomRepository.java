package com.example.demo;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findByPost();

    void delete(T entity);
}
