package com.example.springfinal.repository.implement;

import com.example.springfinal.repository.CustomizedRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class CustomizedRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements
        CustomizedRepository<T, ID> {
    private EntityManager entityManager;

    public CustomizedRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager, EntityManager entityManager1) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public T refresh(T t) {
        entityManager.refresh(t);
        return t;
    }
}
