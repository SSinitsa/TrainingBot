package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Manager;
import com.ssinitsa.telegram.bot.repository.ManagerRepository;
import com.ssinitsa.telegram.bot.services.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends AbstractEntityService<Manager> implements IManagerService {
   @Autowired
    ManagerRepository repository;
}
