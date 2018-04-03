package com.ssinitsa.telegram.bot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ICommonController<T> {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> readAll();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<?> read(int id);

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> save(T any);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> delete(int id);
}
