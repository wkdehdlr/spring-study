package com.example.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account> {
    List<Account> findByUsernameStartsWith(String name);

    @Query("SELECT a FROM #{#entityName} AS a WHERE a.username = :title")
    List<Account> findByUsername(@Param("title")String name, Sort sort);
}
