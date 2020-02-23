package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommnetRepositoryTest {

    @Autowired
    CommnetRepository commnetRepository;

    @Test
    public void crud(){
        Optional<Comment> byId = commnetRepository.findById(100L);
        assertThat(byId).isEmpty();
        byId.orElseThrow(IllegalAccessError::new);
        Comment comment = byId.orElse(new Comment());
    }

}