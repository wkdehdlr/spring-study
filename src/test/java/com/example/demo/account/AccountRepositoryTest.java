package com.example.demo.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void run() throws SQLException {
         try(Connection connection = dataSource.getConnection()) {
             DatabaseMetaData metaData = connection.getMetaData();
             System.out.println(metaData.getURL());
             System.out.println(metaData.getDriverName());
             System.out.println(metaData.getUserName());
         }
    }

    @Test
    public void di(){
        Account account = new Account();
        account.setUsername("doik");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();
        Account account1 = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(account1).isNotNull();
        Account account2 = accountRepository.findByUsername("asefasefasef");
        assertThat(account2).isNull();

    }
}