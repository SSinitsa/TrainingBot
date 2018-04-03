package com.ssinitsa.telegram.bot.services;

import com.ssinitsa.telegram.bot.entity.Materials;

public interface IMaterialsService extends IAbstractEntityService<Materials> {

    Materials findByTitle (String title);

}
