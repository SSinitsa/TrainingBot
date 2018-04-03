package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.AbstractEntity;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
public class BaseController<T extends AbstractEntity> implements ICommonController<T> {
    private final IAbstractEntityService<T> service;

    @Override
    public ResponseEntity<?> readAll() {
        try {
            log.info("Начало поиска всех");
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("При поиске всех возникла ошибка: ", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> read(@PathVariable final int id) {
        try {
            log.info("Начало поиска");
            return new ResponseEntity<>(service.find(id), HttpStatus.OK);
        } catch (Exception e) {
            log.error("При поиске возникла ошибка: ", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> save(@RequestBody final T any) {
        try {
            log.info("Начало сохранения");
            service.save(any);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("При сохранении возникла ошибка: ", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            log.info("Удаление");
            service.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error("При удалении возникла ошибка: ", e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

