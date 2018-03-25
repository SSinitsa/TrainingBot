package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Test extends AbstractEntity {

    @Column
    private String title;

    @OneToMany
    private List<Question> questions;

}
