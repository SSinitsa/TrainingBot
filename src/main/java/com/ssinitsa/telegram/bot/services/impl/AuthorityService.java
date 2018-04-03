package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Authority;
import com.ssinitsa.telegram.bot.repository.AuthorityRepository;
import com.ssinitsa.telegram.bot.services.IAuthorityServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService extends AbstractEntityService<Authority> implements IAuthorityServie {

    @Autowired
    AuthorityRepository repository;

}
