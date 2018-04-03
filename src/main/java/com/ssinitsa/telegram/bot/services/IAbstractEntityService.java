package com.ssinitsa.telegram.bot.services;


import com.ssinitsa.telegram.bot.entity.AbstractEntity;

import java.util.List;

public interface IAbstractEntityService<T extends AbstractEntity> {

    T find(long id);

    List<T> findAll();

    T save(T entity);

    void delete(long id);

}
