package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository<Post> {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Post> findByPost() {
        return entityManager.createQuery("SELECT p FROM post AS p")
                .getResultList();
    }

    @Override
    public void delete(Post entity) {
        entityManager.remove(entity);
    }
}
