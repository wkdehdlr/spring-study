package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

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


    @Test
    public void findByUsernameStartsWith(){
        Account account = new Account();
        account.setUsername("doik jang");
        accountRepository.save(account);

        List<Account> all = accountRepository.findByUsernameStartsWith("doik");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByUsername(){
        Account account = new Account();
        account.setUsername("doik jang");
        accountRepository.save(account);

        List<Account> all = accountRepository.findByUsername("doik", Sort.by("Username"));
        assertThat(all.size()).isEqualTo(1);
    }
}