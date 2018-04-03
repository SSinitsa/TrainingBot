package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.AbstractEntity;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AbstractEntityService<T extends AbstractEntity> implements IAbstractEntityService<T> {

    @Autowired
    JpaRepository<T, Long> repository;


    @Override
    public T find(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
