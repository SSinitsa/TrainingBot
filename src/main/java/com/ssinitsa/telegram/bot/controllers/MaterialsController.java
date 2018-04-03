package com.ssinitsa.telegram.bot.controllers;

import com.ssinitsa.telegram.bot.entity.Materials;
import com.ssinitsa.telegram.bot.services.IAbstractEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materials")
public class MaterialsController extends BaseController<Materials> {

    @Autowired
    public MaterialsController(IAbstractEntityService<Materials> materialsService) {
        super(materialsService);
    }
}
