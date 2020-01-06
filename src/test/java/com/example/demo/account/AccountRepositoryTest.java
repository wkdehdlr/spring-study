package com.example.demo.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByUsername(){
        Account account = new Account();
        account.setUsername("mac");
        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();

        Optional<Account> byUsername = accountRepository.findByUsername(account.getUsername());
        assertThat(byUsername).isNotEmpty();
        assertThat(byUsername.get().getUsername()).isEqualTo("mac");
    }

}