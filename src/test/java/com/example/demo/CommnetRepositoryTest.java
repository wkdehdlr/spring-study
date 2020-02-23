package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CommnetRepositoryTest {

    @Autowired
    CommnetRepository commnetRepository;

    @Test
    public void crud(){
        Comment comment = new Comment();
        comment.setComment("spring data jpa");
        comment.setLikeCount(55);
        commnetRepository.save(comment);

        Comment comment2 = new Comment();
        comment2.setComment("hibernate");
        commnetRepository.save(comment2);

        List<Comment> commentList = commnetRepository.findByCommentContains("Spring");
        assertThat(commentList.size()).isEqualTo(1);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Page<Comment> comments = commnetRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        assertThat(comments.getNumberOfElements()).isEqualTo(2);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount",100);

        Future<List<Comment>> future =
                commnetRepository.findByCommentContains("Spring",pageRequest);
    }
}