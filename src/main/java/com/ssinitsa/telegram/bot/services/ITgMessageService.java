package com.ssinitsa.telegram.bot.services;

import com.ssinitsa.telegram.bot.entity.TgMessage;

public interface ITgMessageService extends IAbstractEntityService<TgMessage> {

    String getHelpMessage();

}
