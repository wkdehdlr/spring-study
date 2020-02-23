package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    boolean contains(T entitiy);
}
