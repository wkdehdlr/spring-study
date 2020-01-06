package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("wkdehdlr@gmail.com");
        account.setUsername("doik");

        Role role = new Role();
        role.setUsername("admin");
        account.getRoles().add(role);

        Session session = sessionFactory.openSession();
        session.save(account);
        sessionFactory.close();

        accountRepository.save(account);
    }
}
