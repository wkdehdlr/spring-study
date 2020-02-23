package com.example.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {
    List<Account> findByUsernameStartsWith(String name);

    @Query("SELECT a FROM Account AS a WHERE a.username = ?1")
    List<Account> findByUsername(String name, Sort sort);
}
