package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="tg_message")
@Entity
public class TgMessage extends AbstractEntity{

    @Column
    private String text;

    @Enumerated(EnumType.STRING)
    private MessageType type;

}
