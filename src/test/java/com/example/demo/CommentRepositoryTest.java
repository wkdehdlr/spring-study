package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void getComment(){
        Account account = new Account();
        account.setUsername("jpa");
        Account saveAccount = accountRepository.save(account);

        Comment comment = new Comment();
        comment.setAccount(saveAccount);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByAccount_Id(saveAccount.getId()).forEach( c -> {
            System.out.println("====================");
            System.out.println(c.getVotes());
        });


        commentRepository.findByAccount_Id(1L);
    }
}