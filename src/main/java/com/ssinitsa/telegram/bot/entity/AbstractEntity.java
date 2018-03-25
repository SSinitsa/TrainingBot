package com.ssinitsa.telegram.bot.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
class AbstractEntity extends AbstractPersistable<Long> {

}
