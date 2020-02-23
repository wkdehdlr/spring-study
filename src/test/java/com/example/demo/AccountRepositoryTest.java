package com.example.demo;


import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.example.demo.QAccount.account;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
        Predicate predicate = account
                .username.containsIgnoreCase("doik")
                .and(account.lastName.startsWith("jang"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();

    }
}