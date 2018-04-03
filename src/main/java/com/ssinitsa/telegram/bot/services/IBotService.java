package com.ssinitsa.telegram.bot.services;

import com.ssinitsa.telegram.bot.entity.Bot;

public interface IBotService extends IAbstractEntityService<Bot> {

    Bot findByName (String name);

}
