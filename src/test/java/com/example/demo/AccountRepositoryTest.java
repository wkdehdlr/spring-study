package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    public void crud(){
        Account account = new Account();
        account.setLastName("doik");
        Account saveAccount = accountRepository.save(account);//persist

        assertThat(entityManager.contains(account)).isTrue();
        assertThat(entityManager.contains(saveAccount)).isTrue();
        assertThat(saveAccount == account);

        Account account2 = new Account();
        account2.setId(account.getId());
        account2.setLastName("doik");
        Account updateAccount = accountRepository.save(account2);//merge

        assertThat(entityManager.contains(account2)).isTrue();
        assertThat(entityManager.contains(updateAccount)).isTrue();
        assertThat(updateAccount == account2);
    }
}