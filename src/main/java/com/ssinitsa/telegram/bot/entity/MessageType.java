package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name="message_type")
@Entity
public class MessageType extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String value;

}
