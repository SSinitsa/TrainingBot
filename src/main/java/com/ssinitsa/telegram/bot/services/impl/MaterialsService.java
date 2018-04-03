package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.Materials;
import com.ssinitsa.telegram.bot.repository.MaterialsRepository;
import com.ssinitsa.telegram.bot.services.IMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialsService extends AbstractEntityService<Materials> implements IMaterialsService{

    @Autowired
    MaterialsRepository repository;

    @Override
    public Materials findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
