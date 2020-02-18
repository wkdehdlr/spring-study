package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommnetRepositoryTest {

    @Autowired
    CommnetRepository commnetRepository;

    @Test
    public void crud(){
        Comment comment = new Comment();
        comment.setComment("hello Comment");
        commnetRepository.save(comment);

        List<Comment> all = commnetRepository.findAll();
        assertThat(all.size()).isEqualTo(1);

        long count = commnetRepository.count();
        assertThat(count).isEqualTo(1);
    }

}